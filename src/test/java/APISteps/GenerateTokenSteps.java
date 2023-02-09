package APISteps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIPayloadConstant;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    //to use my token in the project I am using static variable
    public static String token; //the variable is destroyed because the code doesn't have a logic to know it is valid for 12 hours. that's why we are doing the if else 12-hour condition with timestamp.
    @Given("a JWT is generated")
    public void a_jwt_is_generated() { // we have to use  admin deatils inorder to generate the token, and note everytime when we run this method it will generate new token.
        //prepare request
        RequestSpecification request = given() //restAssured BDD Approach
                .header(APIConstants.Header_Key_Content_Type, APIConstants.Header_Value_Content_Type)
                .body(APIPayloadConstant.adminPayload());

        Response response=request.when().post(APIConstants.GENERATE_TOKEN_URI); //variale name followed by "when()" keyword(since we are doing send request, and we are doing post request)

/*note: diff between sout and prettyprint
in sout we can specify what exactly we want  in console,
 whereas PrettyPrint will print the whole body.*/

        //printing the response body
      //  response.prettyPrint(); we had this code just to check are we getting token or not.

// to get particular value form the key, we use this particular method is called "jsonpath(), basically we are extracting the value form the response body
        token= "Bearer " +response.jsonPath().getString("token"); //note we made this token as global by just adding "Bearer" , so that we can use this token anywhere  and  we want only the value from the response body(just token value) , so we are passing  the key "token" to get the value
        System.out.println(token); // need to print the token value in the console


    }
}
