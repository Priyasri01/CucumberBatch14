package steps;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.LoginPage;

public class PageInitializer { /*in here we are creating object for all the page class ,
 as we know the main purpose of the framework is so flexible , maintainable , well organized.
 that's why all object we  are maintaining in one class and its respective locators are available in the respective page  under pageS package.
 and on the commonMethod class  we extended this class so we can utilize the properties .*/
    public static LoginPage login;
    public static DashboardPage dashboard;

    public static AddEmployeePage addEmployee;

    public static EmployeeListPage employeeList;
    public static void intializePageObjects(){ /*  we call this method on commonmethod class Inside the OpenBrowserAndLauchApplication()method.
         because once we launch the application then only we will process the testcases on the respective pages/window/screen
         that's why we are calling this method after the launch method and also we are calling this method  only one time in the commonmethod it's will take care all page process.
          because in here  we created separate object for all the pages(like for loginpage, dashboardpage, addemployeepage and so on..) and
          thses objects will call automatically throughout the framework by having this method on commonMethod class */

        login = new LoginPage();
        dashboard = new DashboardPage();
        addEmployee= new AddEmployeePage();
        employeeList= new EmployeeListPage();
    }

}
