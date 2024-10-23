import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class CreateMapping
{
    //Star wiremock server

    //test that through Rest Assured
    public void createStub(){
        //Create a stub
        stubFor(get(urlEqualTo("/api/services"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type","application/json")
                        .withBody("[" +
                                "{\"id\":1,\"name\":\"kelvin\",\"dept\":\"Medic\"}," +
                                "{\"id\":2,\"name\":\"kelvin\",\"dept\":\"Teacher\"}," +
                                "{\"id\":3,\"name\":\"kelvin\",\"dept\":\"Driver\"}" +
                                "]")
                ));
    }
    @Test
    public void verifyStub(){
        createStub();
        RestAssured.baseURI = "http://localhost:8080";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .when()
                .get("/api/services")
                .then().assertThat()
                .statusCode(200)
                .log().body();
    }
}
