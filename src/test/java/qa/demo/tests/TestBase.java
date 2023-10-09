package qa.demo.tests;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import qa.demo.config.BookStoreConfig;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    protected static final BookStoreConfig config = ConfigFactory.create(BookStoreConfig.class, System.getProperties());

    @BeforeAll
    public static void beforeAll(){
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();
        Configuration.pageLoadStrategy = "eager";
    }
}
