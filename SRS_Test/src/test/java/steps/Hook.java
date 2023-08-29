package steps;

import base.DriverHandler;
import com.vimalselvam.cucumber.listener.Reporter;
import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hook{

    private WebDriver driver;
    public Scenario scenario;

    public WebDriver getDriver(){
        return DriverHandler.GetInstanceDriverHandler().getDriver();
    }

    @Before
    public void InitiliazeTest(Scenario scenario){
        System.out.println("Running Scenario: " + scenario.getName());

        // Here Singleton pattern is being used, to avoid opening a new browser each time a scenario runs
        this.scenario = scenario;
        driver = DriverHandler.GetInstanceDriverHandler().getDriver();
    }

    //this will run after each scenario
    @After
    public void TearDownTest(Scenario scenario){

        //Add screenshot
        if(scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                //This takes a screenshot from the driver at save it to the specified location
                File sourcePath = ((TakesScreenshot) DriverHandler
                        .GetInstanceDriverHandler().getDriver()).getScreenshotAs(OutputType.FILE);

                //Creates the destination path
                File destinationPath = new File(System.getProperty("user.dir") + "/report/screenshots/" + screenshotName + ".png");

                //Copy taken screenshot from source location to destination location
                Files.copy(sourcePath, destinationPath);

            } catch (IOException e) {
            }
        }
    }
}
