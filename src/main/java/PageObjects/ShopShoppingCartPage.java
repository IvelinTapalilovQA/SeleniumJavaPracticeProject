package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShopShoppingCartPage {

    WebDriverWait wait;

    public ShopShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(css = ".collapse-button")
    WebElement promoLink;
    @FindBy(css = ".promo-input")
    WebElement promoInput;
    @FindBy(xpath = "//span[text()='Add']/parent::button")
    WebElement addBtn;
    @FindBy(xpath = "//a[text()='Proceed to checkout']")
    WebElement checkoutBtn;
    @FindBy(css = ".cart-item .remove-from-cart")
    List<WebElement> deleteButtons;
    @FindBy(css = ".label.js-subtotal")
    WebElement itemCount;

    public void clickOnPromoLink() {
        promoLink.click();
    }

    public void enterPromoCode(String promoCode) {
        promoInput.sendKeys(promoCode);
    }

    public void clickOnAddBtn() {
        addBtn.click();
    }

    public void clickOnCheckoutBtn() {
        checkoutBtn.click();
    }

    public void clickOnDeleteBtn(int index) {
        deleteButtons.get(index).click();
    }

    public String extractTheCountOfItems(String text) {
        wait.until(loweredTextToBePresentInElement(itemCount, text));
        return itemCount.getText();
    }

    public ExpectedCondition<Boolean> loweredTextToBePresentInElement(
            final WebElement element, final String text) {

        return driver -> {
            try {
                String elementText = element.getText().toLowerCase();
                return elementText.contains(text.toLowerCase());
            } catch (StaleElementReferenceException e) {
                return null;
            }
        };
    }
}