package Steps;

import Pages.DashboardPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        // Write code here that turns the phrase above into concrete actions
        //launch to website
        openBrowserAndNavigateToURL();
        //  driver=new ChromeDriver();
        // driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        // driver.manage().window().maximize();
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        //   loginPage loginPage=new loginPage();
        // Write code here that turns the phrase above into concrete actions
        //   WebElement userName=driver.findElement(By.id("txtUsername"));
        // to avoid hard coding we are going to use
        //   userName.sendKeys(ConfigReader.getPropertyValue("username"));
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("Batch16 scripts");
        sendText(ConfigReader.getPropertyValue("username"),loginPage.userNameField);
        //  WebElement pass=driver.findElement(By.id("txtPassword"));
        // pass.sendKeys(ConfigReader.getPropertyValue("password"));
        Log.info("username is correct");
        sendText(ConfigReader.getPropertyValue("password"),loginPage.passwordField);
        Log.info("password is correct");
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
        // loginPage loginPage=new loginPage();
        //  WebElement loginButton = driver.findElement(By.name("Submit"));
        //  loginButton.click();
        click(loginPage.loginButton);
    }
    @Then("user is successfully logged in the application")
    public void user_is_successfully_logged_in_the_application() {
        System.out.println("successfully added");
    }
    @When("user enters the username {string} and the password {string}")
    public void user_enters_the_username_and_the_password(String userName, String password) {
        sendText(userName,loginPage.userNameField);
        sendText(password,loginPage.passwordField);
    }
    @When("clicks on login Btn")
    public void clicks_on_login_btn() {
        click(loginPage.loginButton);
    }
    @Then("the user is logged in and verifies the message {string}")
    public void the_user_is_logged_in_and_verifies_the_message(String expectedMsg) {
        String actualMsg = dashboardPage.WelcomeMsg.getText();
        Assert.assertEquals(actualMsg,expectedMsg);
    }
    @Then("the user is not logged in and verifies the message {string}")
    public void the_user_is_not_logged_in_and_verifies_the_message(String expectedMsg) {
        String actualErrorMsg = loginPage.errorMsgField.getText();

        Assert.assertEquals(actualErrorMsg,expectedMsg);
    }
    @When("the user Enters the userName password and clicks on login button Then the errorMsg is verified")
    public void the_user_enters_the_user_name_password_and_clicks_on_login_button_then_the_error_msg_is_verified
            (io.cucumber.datatable.DataTable dataTable) {
         List<Map<String,String>> datalist=dataTable.asMaps();
         for(Map<String,String>data:datalist){
             String userName = data.get("username");
             String password = data.get("password");
             String expectedError = data.get("errorMsg");

             sendText(userName,loginPage.userNameField);
             sendText(password,loginPage.passwordField);
             click(loginPage.loginButton);

             String actualError = loginPage.errorMsgField.getText();
             Assert.assertEquals(actualError,expectedError);


         }

}

    }


