package Steps;

import Pages.AddEmployeePage;
import Pages.DashboardPage;
import Pages.EmployeeSearchPage;
import Pages.LoginPage;

public class PageInitializers {
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeSearchPage employeeSearchPage;

    //    initalize all the page objects
    public static void initializePageObjects() {
        loginPage = new LoginPage();
        dashboardPage=new DashboardPage();
        addEmployeePage=new AddEmployeePage();
        employeeSearchPage=new EmployeeSearchPage();
    }
}
