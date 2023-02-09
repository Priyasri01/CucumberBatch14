package APIPackage;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

/*
to change the order of execution  we use this "FixMethodOrder" .since it is executing in top to bottom approach, which is not good for this. because i want to run  "createmployee" method first then execute the "getOneemployee"
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING) //  the method will excute  all my method in asending/alpha order.

public class HardCodeExamples {
    static String employee_id; // created this variable as static so, that we can utilize this vaible among other method

    // one thing to remember
    /*base uri in here(rest assured) is only base url , no endpoint  ---> base uri = base url .Because this rest assured follows BDD approach , so the endpoint will be under when keyword. where the meaning of each keywords are
    Given - to prepare the request
    When - send request/hitting  the end point ( in here only we will use end-point to send the request)
    Then
     */

    //end then using when keyword, we will send the end point
/*
Important note:
when we do manual testing in postman, the base uri contains(baseurl  + endpoint) but in reset assured automation API .
 The endpoint contain  under “Then” Not in “Given”. both are separated(check below)
 The endpoint will be under "When" keyword
 */
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api"; /* will get the base url in swagger documents.
 note in here we must type "http://" before the url. and also note we must  have  two "=" because  one  equal is define  the url and another one is to store the url in reference variable,
  otherwise we will get error */
    /*NOTE: AS WE KNOW IF THE CONFIG PART IS NOT GOIHN TO CHANGE WE USE TO PUT IN "Config.proerties" but we are  not put this "uri" in config .
     because the endpoint we keep on change and in here we are checking middleware testing,so it's not ideal to put this uri  in config properties */
    String token= "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzQxNDY3NzksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY3NDE4OTk3OSwidXNlcklkIjoiNDc3MCJ9.1TfFk5VGNyapupx866cg-Rcx2HAHb4_OmIRYDKQBAiQ"; /* We are generating the token in postma and bring it here
    and store in reference varible, note before  the token we have to mention the type of token which is "Bearer"*/

        @Test
        public void bgetOneEmployee(){
            //prepare the request
            //to prepare the request, we use "RequestSpecification" interface in here. basically we are perparing  request . as we know "RestAssured" follow BDD approach . so to prepare request we are using "Given" keyword.

            RequestSpecification request = given().header("Authorization", token) /* preparing the request by using "given" keyword. note for given it will ask to import make sure your importing "static import".
            and also we have to do same thing what we did in postman  for get one employee(two things 1.header(content type,authorization)2.Query parameter we will enter the "header"(under header will select two one is content-type and other one authorization)  */
                    .header("Content-Type", "application/json")//providing content type and value under  "Headers"
                    .queryParam("employee_id", employee_id);//providing key and value under "Query Params" NOTE : WE call the varibale "employee_id" instead of hardcoding.

            //to hit the end point/ to send the request which will return response
            Response response = request.when().get("/getOneEmployee.php"); /* now we want to do  sendrequest/makerequest . since i already prepared the request and store in "request" variable .
            so here to make the request i calling that variable and used the "when" keyword and specified the endpoint inside the get(" "). why it's "get" here because we are perform getoperation.  and also i store the return response  inside the response Interface.*/

            // System.out.println(response.asString()); //request to print the data as string by  using the method "asString".
            response.prettyPrint(); // this will print all details in the console. note prettyprint is just alter of sout. and to be more profissional will use prettyprint.
            //verifying the status code
            response.then().assertThat().statusCode(200); // now in here we are verifying using "Then" keyword followed by "assertThat()" method. because planning to do assertion for verification. check the status code.

/* note: checking  only status code is not ideal enough   , so in order to do other verification, like body contains string,
 compare string value and  we can use hamcrest matchers. Hamcrest is class that contains methods(jsonPath) to perform Assertion */
/*

About Hamcrest matchers.
	It is class that contains method to perform assertions
About Jsonpath:
JsonPath---> it  refers class , yeah its similar like  "response.json" where we convert regular text to json format
Jsonpath()--- it refer the method/function belongs to JasonPath class

Why we are using  this class JsonPath?
JsonPath is calss , in which we use jsonpath() method to get the resposebody details.
 */
            //using jsonpath method, we are extracting the value from the response body and storing them in firstname
            String firstName = response.jsonPath().getString("employee.emp_firstname");
            System.out.println(firstName); // just to know the output we are printing them
            //first way of assertion
            Assert.assertEquals("pupppy", firstName);

            //second way of assertion to verify the value in response body using hamcrest matchers. for the "equalTo" we have import hamcrest  and ensure it's static import "import static org.hamcrest.Matchers.*;"
            response.then().assertThat().body("employee.emp_firstname", equalTo("pupppy"));


        }
        @Test
        public void acreateEmployee(){

            RequestSpecification request = given().header("Authorization", token)
                    .header("Content-Type", "application/json").
                    body("{\n" +
                            "  \"emp_firstname\": \"pupppy\",\n" +
                            "  \"emp_lastname\": \"ragul\",\n" +
                            "  \"emp_middle_name\": \"MS\",\n" +
                            "  \"emp_gender\": \"F\",\n" +
                            "  \"emp_birthday\": \"2023-01-14\",\n" +
                            "  \"emp_status\": \"Cont\",\n" +
                            "  \"emp_job_title\": \"QA \"\n" +
                            "}");
            Response response = request.when().post("/createEmployee.php"); //  in here we are do creating operation so we are using "post" request
            response.prettyPrint();
            //verfying the statuys code which is 201
            response.then().assertThat().statusCode(201);
            //getting the employee id from the response body and use it as static one, so that i can use this variable with other class and method without creating object.
            employee_id = response.jsonPath().getString("Employee.employee_id");
            System.out.println(employee_id);
            response.then().assertThat().body("Employee.emp_lastname", equalTo("ragul"));
            response.then().assertThat().body("Employee.emp_middle_name", equalTo("MS"));
            //verify console header
            response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18"); // provide key and value to verify the header like key is "server" and value " Apach...and so on"

        }

    @Test
    public void cupdateEmployee(){
            //make request
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json").
                body("{\n" +
                        "  \"employee_id\": \""+ employee_id +"\",\n" +
                        "  \"emp_firstname\": \"sohel\",\n" +
                        "  \"emp_lastname\": \"abbasi\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2015-01-12\",\n" +
                        "  \"emp_status\": \"conf\",\n" +
                        "  \"emp_job_title\": \"qa\"\n" +
                        "}");
//send request
        Response response = request.when().put("/updateEmployee.php");
        response.prettyPrint();

        //verification with status
        response.then().assertThat().statusCode(200);

        //verify  the body message by using "Hamcrest Matcher" class
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));
    }


    @Test
public void dgetUpdatedEmployee(){
    RequestSpecification request = given().header("Authorization", token)
            .header("Content-Type", "application/json")
            .queryParam("employee_id", employee_id);

    //to hit the end point/ to make the request which will return response
    Response response = request.when().get("/getOneEmployee.php");

    // System.out.println(response.asString());
    response.prettyPrint();
    //verifying the status code
    response.then().assertThat().statusCode(200);
    response.then().assertThat().body("employee.emp_job_title", equalTo("QA"));
}
    }

