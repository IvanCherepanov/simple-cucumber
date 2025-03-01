package hellocucumber;

import io.cucumber.java.ru.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PaymentSteps {
    private double cardBalance;
    private double productPrice;
    private String paymentResultMessage;

    @Дано("пользователь находится на странице оформления заказа")
    public void пользователь_находится_на_странице_оформления_заказа() {
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