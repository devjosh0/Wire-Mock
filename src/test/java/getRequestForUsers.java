import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class getRequestForUsers extends UsersStubs {

    @Test
    ///Fetch all users
    public void fetchAllUsers(){
        //Call users stubs
       UsersStubs usersStubs = new UsersStubs();
       usersStubs.allUsersStubsWithRedirect();

        //Set the wiremock baseURL
        baseURI = "http://localhost:8080";
        given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().get("/userslist/redirect").then()
                .assertThat().statusCode(404)
                .log().all();
    }
}
