package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.MyAccount;

public class MyAccountPage {

    private WebDriver driver;

    private MyAccount myAccount;

    //using dependency injection for Hook
    public MyAccountPage(Hook hook) {
        this.driver = hook.getDriver();
        myAccount = new MyAccount(driver);
    }
    @Then("Switch to map frame")
    public void switchToMapFrame() throws Throwable{
        Thread.sleep(10000);
        driver.switchTo().frame(0);
    }
    @Then("Search by Charge Point ID")
    public void switchSearchtoChargePointId() throws Throwable{
        myAccount.ClickSearchParameterBtn();
        myAccount.SwitchToSearchByChargePointId();
        //Thread.sleep(5000);
        myAccount.EnterChargePointID();
    }

    @Then("Search by Location")
    public void switchSearchtoLocation() throws Throwable{
         myAccount.ClickSearchParameterBtn();
         myAccount.SwitchToSearchByLocation();
         myAccount.EnterLocation();
    }

}



