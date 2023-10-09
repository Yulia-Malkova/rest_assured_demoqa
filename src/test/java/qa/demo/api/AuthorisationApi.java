package qa.demo.api;

import io.qameta.allure.Step;
import qa.demo.models.LoginBodyModel;
import qa.demo.models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static qa.demo.specs.BookStoreSpec.loginRequestSpec;
import static qa.demo.specs.BookStoreSpec.loginResponseSpec;

public class AuthorisationApi {
    @Step("Авторизация в системе")
    public static LoginResponseModel successfulAuthorisation(String login, String password) {

        LoginBodyModel userCredentials = new LoginBodyModel();
        userCredentials.setUserName(login);
        userCredentials.setPassword(password);

        return
                given(loginRequestSpec)
                        .body(userCredentials)
                        .when()
                        .post()
                        .then()
                        .spec(loginResponseSpec)
                        .extract().as(LoginResponseModel.class);
    }

}
