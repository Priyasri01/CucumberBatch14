package APIPackage;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class HardExample03 {

    //    initialise the Base URI
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzQ3ODczOTUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY3NDgzMDU5NSwidXNlcklkIjoiNDk5MCJ9.2hYPiyhV4AJocuxGZGcR7sN1u5ru-dIQaSBNRuSdVtA";

    @Test
    public void createEmployee() {
        //prepare the request
        RequestSpecification request = given().headers("Content-Type", "application/json").headers("Authorization", token)
                .body("{\n" +
                        "  \"emp_firstname\": \"MR\",\n" +
                        "  \"emp_lastname\": \"Jaay\",\n" +
                        "  \"emp_middle_name\": \"BEEE\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2023-01-20\",\n" +
                        "  \"emp_status\": \"Unemploy\",\n" +
                        "  \"emp_job_title\": \"noEmployee\"\n" +
                        "}");
//         send the request and get response
        Response resp = request.when().post("/createEmployee.php");
//         print the response
        resp.prettyPrint();
//extract the first name from the response

        String empFname = resp.jsonPath().getString("Employee.emp_firstname");
        System.out.println(empFname);

//         assert that the first name is MR
       // Assert.assertEquals(empFname, "MR");
    }

    //     write the request to get all the employeess and print the data on console
    @Test
    public void getAllEmployees() {
        RequestSpecification request = given().headers("Content-Type", "application/json").headers("Authorization", token);

        Response resp = request.when().get("/getAllEmployees.php");

        System.out.println(resp.asString());
    }

    @Test
    public void getJobTitle() {

        RequestSpecification request = given().headers("Content-Type", "application/json").headers("Authorization", token);

        Response resp = request.when().get("/jobTitle.php");

     String res = resp.jsonPath().getString("Jobs[0].id");


       //  resp.prettyPrint(); // note prettyprint works only for response/jsonformat
//          print all the job titles only from the response
//          check the size of array
        String array = resp.jsonPath().getString("Jobs");
//         homework
//          find the size of the json array
       List jobs=resp.jsonPath().getList("Jobs");
        System.out.println(jobs.size());

        for (int i = 0; i< jobs.size() ; i++) {
            String x = resp.jsonPath().getString("Jobs[" + i + "].job");
            System.out.println(x);

        }
//about "gson" json element is just a return type and we can't work further with it, we need to parse to jsonobject or jsonarray to work with
        /*
        //declare the parser to convert the string body to the json object
          JsonObject jsonData= new JsonParser().parse(body).getAsJsonObject();

          JsonElement valueOfKeyJobs = jsonData.get("Jobs");

          JsonArray arrayData = valueOfKeyJobs.getAsJsonArray();

          System.out.println(arrayData.size());
          JsonElement data0 = arrayData.get(0);

          JsonObject dataOBJ = data0.getAsJsonObject();

          JsonElement id = dataOBJ.get("id");
          System.out.println(id);
         */

    }
}
