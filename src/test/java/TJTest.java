import com.codeborne.selenide.Configuration;
import data.Topic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TJTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        open("https://journal.tinkoff.ru/");
    }

static Stream<Arguments> afterChoiceTopicShouldBeChangeRef(){
        return Stream.of(Arguments.of(Topic.INVEST,List.of("Инвестразборы", "Инвестидеи",
                        "Инвестиции для начинающих", "Инвестиции для продвинутых", "Смотреть все")),

                Arguments.of(Topic.BUSINESS,List.of("Как вести бизнес в России", "Новости для бизнеса",
                        "Кейсы: открыли бизнес", "Мнения предпринимателей","Смотреть все")),

                Arguments.of(Topic.SO_WHAT,List.of("Налоги и вычеты", "Суды: теория и практика",
                        "Выплаты и льготы", "Изумительные истории","Смотреть все")));
}

    @MethodSource
    @Tag("MAJOR")

    @ParameterizedTest(name="Для темы {0} отображаются ссылки {1}")
    void afterChoiceTopicShouldBeChangeRef(Topic topic, List<String> refs) {
        $(".flows--fvvyY"). $(byText(topic.toString())).click();
        $$(".inner--k2l5d a").shouldHave(texts(refs));

    }





}
