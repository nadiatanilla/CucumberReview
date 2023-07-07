package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {
    @FindBy(id = "txtUsername")
    public WebElement userNameField;

    @FindBy(id = "txtPassword")
    public WebElement passwordField;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;
    @FindBy(id = "spanMessage")
    public WebElement errorMsgField;

    //TO INITLISE ELEMENTS OF THIS PAGE WE HAVE TO CALL IT IN CONSTRUCTOR
    // CONSTRUCTOR BLOCK OF CODE
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

}
