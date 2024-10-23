import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class postRequestUsers extends UsersStubs {
    @Test
    // Save users
    public void saveAllUsers(){
        //Call users stubs
        UsersStubs usersStubs = new UsersStubs();
        usersStubs.saveUserWithSuccess();

        //Set the wiremock baseURL
        baseURI = "http://localhost:8080";

        // Creating some user data
        JSONObject request = new JSONObject();
        request.put("name","Hussein Amadu");

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when().post("/saveusers")
                .then().assertThat()
                .statusCode(201).log().all();
    }
}
