package qa.demo.api;

import io.qameta.allure.Step;
import qa.demo.models.BookAddingBodyModel;
import qa.demo.models.IsbnModel;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static qa.demo.specs.BookStoreSpec.*;

public class BookApi {
    @Step("Добавить книгу")
    public static void bookAdding(String bookId, String userId, String token) {

        IsbnModel isbnModel = new IsbnModel();
        isbnModel.setIsbn(bookId);
        List<IsbnModel> isbn = new ArrayList<>();
        isbn.add(isbnModel);

        BookAddingBodyModel bookAddingInfo = new BookAddingBodyModel();
        bookAddingInfo.setCollectionOfIsbns(isbn);
        bookAddingInfo.setUserId(userId);

                given(bookAddingSpec)
                        .header("Authorization", "Bearer " + token)
                        .body(bookAddingInfo)
                        .when()
                        .post()
                        .then()
                        .spec(bookAddingResponseSpec);
    }

    @Step("Удалить все книги из профиля пользователя")
    public static void bookDeletion(String userId, String token) {

        given(bookDeletionRequestSpec)
                .header("Authorization", "Bearer " + token)
                .param("UserId", userId)
                .when()
                .delete()
                .then()
                .spec(bookDeletionResponseSpec);
    }
}