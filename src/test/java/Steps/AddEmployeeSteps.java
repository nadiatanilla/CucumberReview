package Steps;

import Utils.CommonMethods;
import Utils.Constants;
import Utils.ExcelReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {


    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
      click(dashboardPage.pimOption);
    }
    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
      click(dashboardPage.addEmp);
    }
    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
       sendText("nadia", addEmployeePage.firstnameField);
       sendText("chak", addEmployeePage.lastnameField);
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveBtn);
    }
    @Then("employee successfully added")
    public void employee_successfully_added() {
        System.out.println("Successfully added");
    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String firstName, String middleName, String lastName) {
    sendText(firstName, addEmployeePage.firstnameField);
    sendText(middleName, addEmployeePage.middleNameField);
    sendText(lastName, addEmployeePage.lastnameField);

    }


    @When("user adds multiple employees using excel from {string} and verify it")
    public void user_adds_multiple_employees_using_excel_from_and_verify_it
            (String sheetName) throws InterruptedException {
        //here we are getting the data from excel file using parameters
        List<Map<String, String>> newEmployees =
                ExcelReader.read(sheetName, Constants.EXCEL_FILE_PATH);

        Iterator<Map<String, String>> itr = newEmployees.iterator();

        //it will check whether we have new element/value or not
        while (itr.hasNext()){

            //in this map, we have data from every single employee one by one it will give us that data
            Map<String,String> mapNewEmp =  itr.next();
            //we are filling the employee data now using mapNewEmp variable
            //BATCH 16, KEYS WHAT WE ARE PASSING HERE SHOULD MATCH WITH THE KEYS IN EXCEL
            sendText(mapNewEmp.get("firstName"),addEmployeePage.firstnameField);
            sendText(mapNewEmp.get("lastName"), addEmployeePage.lastnameField);
            sendText(mapNewEmp.get("middleName"), addEmployeePage.middleNameField);
            sendText(mapNewEmp.get("photograph"), addEmployeePage.photograph);

            //we can enter username and password only after selecting the checkbox
            if(!addEmployeePage.checkBoxLocator.isSelected()){
                click(addEmployeePage.checkBoxLocator);
            }
            sendText(mapNewEmp.get("userName"),addEmployeePage.usernameTextFieldBox);
            sendText(mapNewEmp.get("password"), addEmployeePage.passwordTextFieldBox);
            sendText(mapNewEmp.get("confirmPassword"), addEmployeePage.confirmPasswordBox);

            //here we are fetching the employee id from the UI using get attribute method
            String empIdValue = addEmployeePage.employeeIdField.getAttribute("value");
            Assert.assertTrue(addEmployeePage.saveBtn.isDisplayed());
            click(addEmployeePage.saveBtn);
            Thread.sleep(3000);
            //we have to verify that the employee has been added
            click(dashboardPage.empListOption);
            //searching the employee using emp id which we just got
            sendText(empIdValue, employeeSearchPage.idTextField);
            click(employeeSearchPage.searchButton);

            //print the value from the table row
            List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
            for (int i=0; i<rowData.size(); i++){
                System.out.println("I am inside the loop");
                //it will return one by one all the data from the row
                String rowText = rowData.get(i).getText();
                //it will print the complete row data
                //output of this will be empid firstname middlename lastname
                System.out.println(rowText);
                //we have to verify this data against the data coming from excel

                String expectedData = empIdValue + " "+mapNewEmp.get("firstName")+" "+
                        mapNewEmp.get("middleName")+" "+mapNewEmp.get("lastName");

                Assert.assertEquals(expectedData, rowText);
                //you can use below code too to verify the data
                //  Assert.assertTrue(expectedData.equals(rowText));

            }
            //to add more employees we need to click on add employee button
            click(dashboardPage.addEmp);
        }
    }

}



