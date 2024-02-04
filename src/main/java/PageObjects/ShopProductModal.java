package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopProductModal {

    WebDriverWait wait;

    public ShopProductModal(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//a[text()='Proceed to checkout']")
    WebElement checkoutBtn;
    @FindBy(xpath = "//button[text()='Continue shopping']")
    WebElement continueBtn;


    public void clickOnCheckoutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        checkoutBtn.click();
    }

    public void clickOnContinueBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        continueBtn.click();
    }
}
