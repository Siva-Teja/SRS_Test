package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;
import java.time.Duration;

public class Home {

    private WebDriver driver;

    public Home(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    //DropDown Button to change Country
    @FindBy(css = ".css-1bafsue.enmru2y9")
    WebElement btnCountryDorpdown;

    //Button to select Country
    @FindBy(xpath = "//span[contains(text(),'United Kingdom')]")
    WebElement btnSelectCountry;

    //Link to accept cookies
    @FindBy(id="cookiebanner-accept-all")
    private WebElement linkCookies;

    //Link to My Account
    @FindBy(partialLinkText = "My account")
    private WebElement myAccount;

    public void SelectCountry() throws InterruptedException {
        btnCountryDorpdown.click();
        btnSelectCountry.click();
    }

    public void AcceptAllCookies() throws InterruptedException {
        By locator = By.id("cookiebanner-accept-all");

        Boolean isPresent = Utils.existsElement( driver, locator);
        if(isPresent) {
            ExpectedCondition e = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return (linkCookies.getSize().height > 11);
                }
            };
            WebDriverWait wait = (new WebDriverWait(driver, Duration.ofSeconds(10)));
            wait.until(e);
            linkCookies.click();

        }
    }

    public void ClickMyAccount() throws InterruptedException{
            myAccount.click();
    }

}
