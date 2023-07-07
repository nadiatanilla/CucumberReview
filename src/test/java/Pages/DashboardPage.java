package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends CommonMethods {


    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmp;

    @FindBy(xpath = "//a[text()='Welcome Admin']")
    public WebElement WelcomeMsg;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement empListOption;

    public DashboardPage(){
        PageFactory.initElements(driver,this);
    }
}
