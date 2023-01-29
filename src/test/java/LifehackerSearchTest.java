import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LifehackerSearchTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @CsvSource({
            "Ашан, https://www.auchan.ru/",
            "Ситилинк, https://www.citilink.ru"
    })
    @ParameterizedTest(name = "Адрес {1} должен быть в результате поиска промокодов по запросу {0}")
    @Tag("MINOR")
    void afterChoiceTopicShouldBeChangeReference(String shopName, String shopUrl) {
        open("https://lifehacker.ru/promokod/");
        $(".search-field").setValue(shopName);
        $(".search-result-inner").shouldHave(text(shopUrl));

    }

    @ValueSource(strings = {"Киберпонедельник",  "Первый заказ"})
    @ParameterizedTest
    @Tag("MINOR")
    void listPromocodeShouldBePresentAfterChoiceTag(String tag) {
        open("https://lifehacker.ru/promokod/tags");
        $$(".cat-tag").findBy(text(tag)).click();
       $$("div[class='content']").shouldHave(CollectionCondition.sizeGreaterThan(20));

    }


}
