# language: ru
Функция: Оплата товара в интернет-магазине

  Сценарий: Успешная оплата товара банковской картой
    Дано пользователь находится на странице оформления заказа
    И у пользователя есть банковская карта с балансом 5000 рублей
    И в корзине товар стоимостью 2000 рублей
    Когда пользователь выбирает оплату банковской картой
    И вводит корректные данные карты
    И нажимает кнопку "Оплатить"
    Тогда оплата проходит успешно
    И баланс карты становится 3000 рублей
    И пользователь видит сообщение "Оплата успешно завершена"

  Сценарий: Неуспешная оплата из-за недостатка средств
    Дано пользователь находится на странице оформления заказа
    И у пользователя есть банковская карта с балансом 1000 рублей
    И в корзине товар стоимостью 2000 рублей
    Когда пользователь выбирает оплату банковской картой
    И вводит корректные данные карты
    И нажимает кнопку "Оплатить"
    Тогда оплата не проходит
    И пользователь видит сообщение "Недостаточно средств на карте"