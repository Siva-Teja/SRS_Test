package runner;
import base.DriverHandler;
import com.vimalselvam.cucumber.listener.*;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.*;
import resources.ConfigFileReader;
import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        //format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        glue = {"steps"},
        //~ will skip the features with that specific tag
        tags = "@smoke",
        monochrome = true,
        plugin = {"pretty","json:target/cucumber-json/cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml", "html:target/cucumber-report-html/Cucumber.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests{

    @BeforeClass
    public static void initExtentReport() {
        //plugin = {"com.cucumber.listener.ExtentCucumberFormatter:report/cucumber_report.html"},
        //ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        //extentProperties.setReportPath("report/report.html");
    }

    //writes in the report
    @AfterClass
    public static void writeExtentReport() {
        try {
            //Reporter.loadXMLConfig(new File(ConfigFileReader.getInstance().getReportConfigPath()));
            //C:/Users/jorge/Desktop/Work/Code/Mine/Java_Selenium_cucumber_testNG/config/extent-config.xml
            //Reporter.loadXMLConfig();
            Reporter.loadXMLConfig(ConfigFileReader.getInstance().getReportConfigPath());
            Reporter.setSystemInfo("user", System.getProperty("user.name"));
            Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
            Reporter.setTestRunnerOutput("Test run report");
        }catch(Exception e){

        }

    }

    //Added  TestNG annotation to allow closing the browser at the end
    @AfterSuite
    public static void tearDown(){
        DriverHandler.GetInstanceDriverHandler().TearDown();
    }
}
