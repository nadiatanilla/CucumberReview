package Steps;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

    @Before
    public void start(){
        openBrowserAndNavigateToURL();
    }
    @After
    public void end(Scenario scenario){
        // weare going to capture ss
        byte[] pic;
        //   pic = takeScreenshot(scenario.getName());
        if (scenario.isFailed()) {
            pic=takeScreenshot("failed/"+scenario.getName());
        }else{
            pic=takeScreenshot("passed/"+scenario.getName());
        }
        // attatch this ss in the report
        scenario.attach(pic, "image/png", scenario.getName());

        closeBrowser();
    }
}
