import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class putRequestForUsers {

    @Test
    // Save users
    public void updateAllUsers(){
        //Call users stubs
        UsersStubs usersStubs = new UsersStubs();
        usersStubs.updateUserWithSuccess();
        //Set the wiremock baseURL
        baseURI = "http://localhost:8080";

        // Creating some user data
        JSONObject request = new JSONObject();
        request.put("name","Hussein Amadu");

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when().post("/updateusers")
                .then().log().all();
    }
}
