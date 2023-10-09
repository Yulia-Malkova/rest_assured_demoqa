package qa.demo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ProfilePage {

    private SelenideElement
            noDataGridElement = $(".rt-noData");

    @Step("Прооверить, что в таблице нет книг")
    public void emptyTableCheck() {
        noDataGridElement.shouldHave(Condition.text("No rows found"));
    }
}

