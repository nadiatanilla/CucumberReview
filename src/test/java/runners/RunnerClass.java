package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // features provide the path of all features file
        features = "src/test/resources/Features/",
        // glue keyword provide the package where all step definition
        glue = "Steps",
        // stops actual execution,it quickly scans all the steps and will privede the missing step def
        // after we did the step definition we have to turn it to value false to execute the code
        dryRun = false,
        // this tag groups the test cases , it can be one or more tags
        // we can run more than one tag. or and,and should both @  be there to be executed
        tags = "@excel",
        // monochrom when you set it to true , it will remove all the irrelevant and unredable info in the consol
        monochrome=true,
        // it used to print all the steps in console
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json","rerun:target/failed.txt"}
)
public class RunnerClass {
}
