package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {


    @FindBy(id = "firstName")
    public WebElement firstnameField;
       @FindBy(id = "lastName")
    public WebElement lastnameField;
       @FindBy(id = "middleName")
       public WebElement middleNameField;

       @FindBy(id="btnSave")

    public WebElement saveBtn;

    @FindBy(id="photofile")
    public WebElement photograph;

    @FindBy(id="employeeId")
    public WebElement employeeIdField;

    @FindBy(id="chkLogin")
    public WebElement checkBoxLocator;

    @FindBy(id="user_name")
    public WebElement usernameTextFieldBox;

    @FindBy(id="user_password")
    public WebElement passwordTextFieldBox;

    @FindBy(id="re_password")
    public WebElement confirmPasswordBox;


    public AddEmployeePage(){
           PageFactory.initElements(driver,this);
       }

}
