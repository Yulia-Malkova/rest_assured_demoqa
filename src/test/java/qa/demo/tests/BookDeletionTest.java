package qa.demo.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import qa.demo.data.TestData;
import qa.demo.models.LoginResponseModel;
import qa.demo.pages.ProfilePage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static qa.demo.api.AuthorisationApi.successfulAuthorisation;
import static qa.demo.api.BookApi.bookAdding;
import static qa.demo.api.BookApi.bookDeletion;

public class BookDeletionTest extends TestBase {

    ProfilePage profilePage = new ProfilePage();
    TestData testData = new TestData();

    @Test
    @DisplayName("Удаление книги из профиля пользователя")
    void bookDeletionTest(){
        LoginResponseModel loginResponse = successfulAuthorisation(testData.login, testData.password);
        bookDeletion(loginResponse.getUserId(), loginResponse.getToken());
        bookAdding(testData.bookId,loginResponse.getUserId(), loginResponse.getToken());
        bookDeletion(loginResponse.getUserId(), loginResponse.getToken());

            open(baseUrl + "/favicon.ico");
            getWebDriver().manage().addCookie(new Cookie("userID", loginResponse.getUserId()));
            getWebDriver().manage().addCookie(new Cookie("expires", loginResponse.getExpires()));
            getWebDriver().manage().addCookie(new Cookie("token", loginResponse.getToken()));

        open(baseUrl + "/profile");
        profilePage
                .emptyTableCheck();
    }
}
