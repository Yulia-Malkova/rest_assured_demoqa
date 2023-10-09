package qa.demo.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import qa.demo.helpers.CustomApiListener;
import qa.demo.tests.TestBase;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class BookStoreSpec extends TestBase {
    public static RequestSpecification loginRequestSpec = with()
            .filter(CustomApiListener.withCustomTemplates())
            .log().uri()
            .log().method()
            .log().body()
            .contentType(JSON)
            .baseUri(config.baseUrl())
            .basePath("/Account/v1/Login");


    public static ResponseSpecification loginResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();

    public static RequestSpecification bookAddingSpec = with()
            .filter(CustomApiListener.withCustomTemplates())
            .log().uri()
            .log().method()
            .log().body()
            .contentType(JSON)
            .baseUri(config.baseUrl())
            .basePath("/BookStore/v1/Books");

    public static ResponseSpecification bookAddingResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(201)
            .build();

    public static RequestSpecification bookDeletionRequestSpec = with()
            .filter(CustomApiListener.withCustomTemplates())
            .log().uri()
            .log().method()
            .log().body()
            .contentType(JSON)
            .baseUri(config.baseUrl())
            .basePath("/BookStore/v1/Books");

    public static ResponseSpecification bookDeletionResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .expectStatusCode(204)
            .build();

}
