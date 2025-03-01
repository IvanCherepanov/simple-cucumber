package hellocucumber;

import io.cucumber.java.en.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static org.assertj.core.api.Assertions.assertThat;

class IsItFriday {
    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}


public class StepDefinitions {
    private String today;
    private String actualAnswer;
    private double cardBalance;
    private double productPrice;
    private String paymentResultMessage;

    @Given("today is Sunday")
    public void today_is_Sunday() {
        today = "Sunday";
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }

    @Given("today is Friday")
    public void today_is_Friday() {
        today = "Friday";
    }

    @Дано("пользователь находится на странице оформления заказа")
    public void пользователь_находится_на_странице_оформления_заказа() {
        // Здесь можно добавить логику перехода на страницу, но для примера просто логируем
        System.out.println("Пользователь на странице оформления заказа");
    }

    @Дано("у пользователя есть банковская карта с балансом {double} рублей")
    public void у_пользователя_есть_банковская_карта_с_балансом_рублей(double balance) {
        this.cardBalance = balance;
        System.out.println("Баланс карты: " + balance + " рублей");
    }

    @Дано("в корзине товар стоимостью {double} рублей")
    public void в_корзине_товар_стоимостью_рублей(double price) {
        this.productPrice = price;
        System.out.println("Стоимость товара: " + price + " рублей");
    }

    @Когда("пользователь выбирает оплату банковской картой")
    public void пользователь_выбирает_оплату_банковской_картой() {
        System.out.println("Выбрана оплата банковской картой");
    }

    @Когда("вводит корректные данные карты")
    public void вводит_корректные_данные_карты() {
        System.out.println("Введены корректные данные карты");
    }

    @Когда("нажимает кнопку \"Оплатить\"")
    public void нажимает_кнопку_оплатить() {
        if (cardBalance >= productPrice) {
            cardBalance -= productPrice;
            paymentResultMessage = "Оплата успешно завершена";
        } else {
            paymentResultMessage = "Недостаточно средств на карте";
        }
        System.out.println("Нажата кнопка 'Оплатить'");
    }

    @Тогда("оплата проходит успешно")
    public void оплата_проходит_успешно() {
        assertThat(paymentResultMessage).isEqualTo("Оплата успешно завершена");
    }

    @Тогда("оплата не проходит")
    public void оплата_не_проходит() {
        assertThat(paymentResultMessage).isEqualTo("Недостаточно средств на карте");
    }

    @Тогда("баланс карты становится {double} рублей")
    public void баланс_карты_становится_рублей(double expectedBalance) {
        assertThat(cardBalance).isEqualTo(expectedBalance);
        System.out.println("Новый баланс карты: " + cardBalance + " рублей");
    }

    @Тогда("пользователь видит сообщение {string}")
    public void пользователь_видит_сообщение(String expectedMessage) {
        assertThat(paymentResultMessage).isEqualTo(expectedMessage);
        System.out.println("Сообщение: " + paymentResultMessage);
    }
}