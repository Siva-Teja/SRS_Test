package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;


public class DriverHandler {
    private WebDriver driver;
    private static DriverHandler _driverHandler;


    private DriverHandler() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    //Here is where the singleton pattern is applied, if the instance is null then call constructor
    // if not, return the instance
    public static DriverHandler GetInstanceDriverHandler(){
        if (null == _driverHandler)
            _driverHandler = new DriverHandler();
        return _driverHandler;
    }

    // Get the driver
    public WebDriver getDriver() {
        return driver;
    }

    // Close the driver
    public void TearDown() {
        driver.close();
        driver.quit();
    }

}
