package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeStpes extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
       // WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
       // pimOption.click();
        click(dashboard.pimOption); /*in here so we are basically calling our click method(which is available in commonMethod
       and it is asking for which element to be clicked so we are providing the object name(dashboard) along
        with reference variable name(PimOption) where the locator is  avilable. */
    }


    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
       // WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
       // addEmployeeOption.click();
        click(dashboard.addEmployeeOption);
    }
    @When("user enter firstname and lastname")
    public void user_enter_firstname_and_lastname() {
       // WebElement firstName = driver.findElement(By.id("firstName"));
       // firstName.sendKeys("Priya");
        sendText(addEmployee.firstNameField,"joshpan");

       // WebElement lastName = driver.findElement(By.id("lastName"));
       // lastName.sendKeys("Hari");
        sendText(addEmployee.lastNameField,"veranula");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
      //  WebElement saveButton = driver.findElement(By.id("btnSave"));
     //   saveButton.click();
        click(addEmployee.saveButton);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("employee Added");
    }

    @When("user enter {string} and {string}")
    public void user_enter_and(String firstName, String lastName) {
        sendText(addEmployee.firstNameField, firstName); /*in this method (on fist parameter we provide the object name where we have all the locator for the web element
        and on the next parameter we mentioned where the data is available . note the data comes from feature file.*/
        sendText(addEmployee.lastNameField, lastName);
    }


    @When("user  enter {string} and {string} for adding multiple employee")// with the help of scenario Outline , we can pass multiple value.
    public void user_enter_and_for_adding_multiple_employee(String firstNameValue, String lastNameValue) {
        sendText(addEmployee.firstNameField, firstNameValue); //note it's look exactly same as above code 59 & 61 . but the different is in here we are adding 3 different value of first name
        sendText(addEmployee.lastNameField, lastNameValue); //note it's look exactly same as above code 59 & 61 . but the different is in here we are adding 3 different value of last name
        //and also not we are getting only one  definition  for all three values. but when we run the code we will see 3 feature file.
    }

    @When("user adds multiple employees and verify they are added successfully")
   // public void user_adds_multiple_employees_and_verify_they_are_added_successfully(io.cucumber.datatable.DataTable dataTable)
    public void user_adds_multiple_employees_and_verify_they_are_added_successfully(DataTable dataTable) //----> note in here instead hard code the io.cucumber.datatable i just import the file
    {
        List<Map<String, String>> employeeNames = dataTable.asMaps(); /*we are getting the data in list of Map and data is coming from feature file which
         is dataTable(this dataTable contains all the dta from feature files) and we have to confirm the data comes as what. in this scenario the data comes asMap.(.asMaps())*/

        //using loop to get one map at time from list of maps
        for (Map<String, String> employee:employeeNames
        ) {

            // getting values from every map by passing the key in argument
            String firstNameValue = employee.get("firstName"); // in here we are using get method to retrieve the value form the map by passing the key inside the get method.
            String middleNameValue = employee.get("middleName");
            String lastNameValue = employee.get("lastName");

            //after we retrieve the data from the data table, now we are passing the value to the application by calling the sendText()method.
            sendText(addEmployee.firstNameField, firstNameValue);
            sendText(addEmployee.lastNameField, lastNameValue);
            sendText(addEmployee.middleNameField, middleNameValue);
            //once data enter in-the respective field, now click the save to button
            click(addEmployee.saveButton); /* note as we know we're adding multiple employee with the help of datatable feature  .
             in data table feature hook , background and test case will run only one time , so that's why once one employee added  we are going back to add employee page to                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            start again the iteration */
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            //till this point one employee has been added
            //verifying the employee is home-work
            click(dashboard.addEmployeeOption);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @When("user adds multiple employee from excel using {string} and verify it")
    public void user_adds_multiple_employee_from_excel_using_and_verify_it(String sheetName)  {

        List<Map<String, String>> empFromExcel =
                ExcelReader.excelListIntoMap(Constants.TESTDATA_FILEPATH, sheetName); /* in here to read the file we are  calling the method from ExcelReader class
                 which is excelListtoMap in which we have ![](../../../../../../AppData/Local/Temp/image.png)the code to read the excel file and passing the path and sheetName
                 (path name comes from constant class & sheetname comes from feature file) inside the parameter*/


        //it returns one map from list of maps
        Iterator<Map<String, String>> itr = empFromExcel.iterator(); //we will get one map at time with the help of iterator

        while (itr.hasNext()){
            //it returns the key and value for employee from excel
            Map<String, String> mapNewEmp = itr.next();
/*once we get the key & value form the map we stored in mapNewEmp variable above(in line 127)and now ,
we are sending the data to the application(hrms) with the help of sendtext()method */
            sendText(addEmployee.firstNameField, mapNewEmp.get("firstName")); //sending firstname
            sendText(addEmployee.middleNameField, mapNewEmp.get("middleName")); //sending middlename
            sendText(addEmployee.lastNameField, mapNewEmp.get("lastName")); //sending lastname
            String empIdValue = addEmployee.empIdLocator.getAttribute("value");
            sendText(addEmployee.photograph, mapNewEmp.get("Photograph")); //sending photo
            if(!addEmployee.checkBox.isSelected()){ // in here we are saying if the check box  is not selected(!) then go inside and click check box
                click(addEmployee.checkBox);
            }
            sendText(addEmployee.createusernameField, mapNewEmp.get("username")); //sending username
            sendText(addEmployee.createpasswordField, mapNewEmp.get("password"));//sending password
            sendText(addEmployee.confirmpasswordField, mapNewEmp.get("confirmPassword"));//confirm password
            click(addEmployee.saveButton);
            System.out.println("click taken on save button");
            //verification is in home-work
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            click(dashboard.empListOption);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("click taken on emp list option");

            //to search the employee, we use emp id what we captured from attribute
            sendText(employeeList.empSearchIdField, empIdValue);
            click(employeeList.searchButton);

            //verifying the employee added(multiple employee) from the excel file

            List<WebElement> rowData =
                    driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));


            for (int i =0; i<rowData.size(); i++){
                System.out.println("I am inside the loop and worried about josh");
                //getting the text of every element from here and storing it into string
                String rowText = rowData.get(i).getText();
                System.out.println(rowText);

                String expectedData = empIdValue + " " + mapNewEmp.get("firstName") /* the reason i put this expectedData inside the for loop
                       is because i am check multiple data from Excel sheet , so for each iterator it will take each row. */
                        + " " + mapNewEmp.get("middleName") + " " + mapNewEmp.get("lastName");

                //verifying the exact details  of the employee
                Assert.assertEquals(expectedData, rowText);

            }

            click(dashboard.addEmployeeOption);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
