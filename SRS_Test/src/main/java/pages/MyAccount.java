package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


public class MyAccount {

    private WebDriver driver;

    public MyAccount(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;

    }

    //button to change search parameter either to location or charge point ID
    @FindBy(css = ".btn.btn-default.dropdown-toggle")
    private WebElement btnChangeSearchParameter;

    //button to search by charge point ID
    @FindBy(partialLinkText = "Search by charge point ID")
    private WebElement btnSearchByChargePointID;

    //button to search by location
    @FindBy(partialLinkText = "Search by location")
    private WebElement btnSearchByLocation;

    //search bar to enter location
    @FindBy(css = ".ToolBox__search__input.form-control.pac-target-input")
    private WebElement searchBarForLocation;


    //search bar to enter charge point ID
    @FindBy(xpath = "//input[@placeholder='Search by charge point ID']")
    WebElement searchBarForChargePointID;

    //select searched location
    @FindBy(xpath = "//span[contains(text(),'Germany')]")
    WebElement searchedLocation;

    //select searched charge point ID
    @FindBy(xpath = "//span[contains(text(),'GBCPIL6500825')]")
    WebElement searchedChargePointID;

    public void ClickSearchParameterBtn() throws InterruptedException {
        btnChangeSearchParameter.click();
    }

    public void SwitchToSearchByLocation() throws InterruptedException {
        btnSearchByLocation.click();
    }

    public void EnterLocation() throws InterruptedException {
        searchBarForLocation.sendKeys("Germany");
        Thread.sleep(2000);
        searchedLocation.click();
        Thread.sleep(8000);
    }
    public void SwitchToSearchByChargePointId() throws InterruptedException {
        btnSearchByChargePointID.click();

    }

   public void EnterChargePointID() throws InterruptedException {

        searchBarForChargePointID.sendKeys("GBCPIL6500825");
        Thread.sleep(4000);
        searchedChargePointID.click();
        Thread.sleep(8000);
    }

}
