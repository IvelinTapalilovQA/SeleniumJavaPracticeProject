package utils;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    private final Properties prop;
    private static final String SCREENSHOTS_DIR = System.getProperty("user.dir") + "src/test/resources/screenshots/";
    private static final String CONFIG_PROP_DIR = System.getProperty("user.dir") + "/src/test/java/utils/config.properties";

    public BaseClass()  {
        prop = new Properties();
        FileInputStream data = null;
        try {
            data = new FileInputStream(CONFIG_PROP_DIR);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            prop.load(data);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeMethod
    protected final void setUp(){
        if (prop.getProperty("browser").equals("chrome")) {
            ChromeDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }
        else if (prop.getProperty("browser").equals("firefox")) {
            FirefoxDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    protected final void tearDown(ITestResult result){
        takeScreenshot(result);
        if (driver != null) {
            driver.close();
        }
    }

    public void navigateToUrl(){
        driver.get(prop.getProperty("url"));
    }

    private void takeScreenshot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            try {
                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
                String testName = testResult.getName();
                FileUtils.copyFile(screenshot, new File(SCREENSHOTS_DIR.concat(testName).concat(".jpg")));
            } catch (IOException e) {
                System.out.println("Unable to create a screenshot file: " + e.getMessage());
            }
        }
    }

    public String generateRandomEmail(){
        return RandomStringUtils.randomAlphanumeric(6, 10) + "@test.com";
    }
}