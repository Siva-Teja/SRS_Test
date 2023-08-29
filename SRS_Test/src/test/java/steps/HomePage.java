package steps;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Home;
import java.util.ArrayList;



public class HomePage {

    private Home homepage;
    private WebDriver driver;

    //using dependency injection for Hook
    public HomePage(Hook hook) {
        this.driver = hook.getDriver();
        homepage = new Home(driver);
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.navigate().to("https://shellrecharge.com/");

    }

    @Then("Accept all cookies if presented")
    public void acceptAllCookiesifPresented() throws Throwable {
        homepage.AcceptAllCookies();
    }

    @Then("Select Required Country")
    public void selectRequiredCountry() throws Throwable {
        homepage.SelectCountry();
        Thread.sleep(5000);
        Assert.assertEquals("Ev charging solutions for your business | Shell Recharge", driver.getTitle());
    }

    @Then("Click on My Account")
    public void clickMyAccount() throws Throwable {
        homepage.ClickMyAccount();
    }


    @Then("Change to new Tab")
    public void changeTabAndValidateTitle() throws Throwable{
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
    }

    @And("Validate Page Title")
    public void validatePageTitle() throws Throwable{
        Assert.assertEquals("Shell Recharge | Home", driver.getTitle());
    }

}