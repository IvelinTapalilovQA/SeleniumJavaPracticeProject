package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopHomePage {

    public ShopHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".thumbnail-container")
    List<WebElement> products;

    public void selectProductByIndex(int index){
        products.get(index).click();
    }
}
