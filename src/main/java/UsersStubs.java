import java.util.UUID;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class UsersStubs {
    public UsersStubs(){

    }
    // Creating GET stubs for users
    public void allUsersStubsWithSuccess(){
     stubFor(get(urlEqualTo("/userslist/ok"))
             .willReturn(ok()
                     .withHeader("Content-Type","application/json")
                     .withBody("Log all users.......")
             ));
    }
    public void allUsersStubsWithFail(){
        stubFor(get(urlEqualTo("/userslist/forbidden"))
                .willReturn(forbidden()
                        .withHeader("Content-Type","application/json")
                        .withBody("This is forbidden......")
                ));
    }
    public void allUsersStubsWithRedirect(){
        stubFor(get(urlEqualTo("/userslist/redirect"))
                .willReturn(temporaryRedirect("/username")
                        .withHeader("Content-Type","application/json")
                        .withBody("This is redirected......")
                ));
    }
    public void allUsersStubsWithUnauthorized(){
        stubFor(get(urlEqualTo("/userslist/unauthorized"))
                .willReturn(unauthorized()
                        .withHeader("Content-Type","application/json")
                        .withBody("This is unauthorized......")
                ));
    }
    // Creating POST stubs for users
   public void saveUserWithSuccess(){
        stubFor(post(urlEqualTo("/saveusers"))
                .willReturn(created().withHeader("Content-Type","Application/json")));
   }

    // Creating PUT stubs for users
    public void updateUserWithSuccess(){
        stubFor(put(urlEqualTo("/updateusers"))
                .willReturn(ok().withHeader("Content-Type","Application/json")));
    }
}
