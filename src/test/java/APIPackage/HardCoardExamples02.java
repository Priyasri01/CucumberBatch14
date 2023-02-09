package APIPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCoardExamples02 {

public static String employee_id;

    String baseurI=RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api/"; // firt get base uri from swagger and add "http://" before hrm.

    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzQxNDY3NzksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY3NDE4OTk3OSwidXNlcklkIjoiNDc3MCJ9.1TfFk5VGNyapupx866cg-Rcx2HAHb4_OmIRYDKQBAiQ";

@Test
  public void bgetOneEmployee(){

     RequestSpecification request = given().header("Authorization",token)
             .header("Content-Type","application/json")
             .queryParam("employee_id",employee_id);

     //send request
      Response response =request.when().get("/getOneEmployee.php");

      // to view the out put in the console we  used this println & prettyprint.
     // System.out.println(response.asString()); // this one we used to get the data in console.
     response.prettyPrint();
     response.then().assertThat().statusCode(200);

String firstName= response.jsonPath().getString("employee.emp_firstname");
    //System.out.println(firstName);
//this re
 Assert.assertEquals("Ramya",firstName);

 //second way of assertion to
response.then().assertThat().body("employee.emp_firstname", equalTo("Ramya"));

  }
@Test
  public void acreateEmployee(){

    //prepare request

      RequestSpecification request = given().header("Authorization",token).header("Content-type","application/json").body("{\n" +
              "  \"emp_firstname\": \"Ramya\",\n" +
              "  \"emp_lastname\": \"PETER\",\n" +
              "  \"emp_middle_name\": \"MS\",\n" +
              "  \"emp_gender\": \"F\",\n" +
              "  \"emp_birthday\": \"1990-01-14\",\n" +
              "  \"emp_status\": \"Contrzctor\",\n" +
              "  \"emp_job_title\": \"QA Tester \"\n" +
              "}");

     Response response =request.when().post("/createEmployee.php");

    response.prettyPrint();
//verify part
      response.then().assertThat().statusCode(201);
employee_id =response.jsonPath().getString("Employee.employee_id");
    System.out.println(employee_id);
//verify header
    response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
  }

  @Test
  public void cupadteEmployee(){

    RequestSpecification request = given().header("Authorization",token).header("Content-Type","application/json")
            .body("{\n" +
                    "  \"employee_id\": \""+ employee_id +"\",\n" +
                    "  \"emp_firstname\": \"uma\",\n" +
                    "  \"emp_lastname\": \"simth\",\n" +
                    "  \"emp_middle_name\": \"MS\",\n" +
                    "  \"emp_gender\": \"M\",\n" +
                    "  \"emp_birthday\": \"1983-01-15\",\n" +
                    "  \"emp_status\": \"contract\",\n" +
                    "  \"emp_job_title\": \"ASST.Manager\"\n" +
                    "}");

    //send request

      Response response=request.when().put("/updateEmployee.php");
      System.out.println(response);

response.then().assertThat().statusCode(200);
      response.then().assertThat().body("Message",equalTo("Employee record Updated"));
  }
  @Test
    public void dgetUpdateEmployee(){ // note since we created update employee now we have to crosscheck  so  now we are getupdate employee and cross checking as thum rule

    RequestSpecification request = given().header("Authorization", token)
            .header("Content-Type", "application/json")
            .queryParam("employee_id",employee_id);

    Response response=request.when().get("/getOneEmployee.php");

    response.prettyPrint();

    //verify
      response.then().assertThat().statusCode(200);
      response.then().assertThat().body("employee.emp_job_title",equalTo("ASST.Manager"));

  }
}
