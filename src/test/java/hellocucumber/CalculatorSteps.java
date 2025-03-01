package hellocucumber;

import io.cucumber.java.ru.*;
import static org.assertj.core.api.Assertions.assertThat;

class Calculator {
    static int add(int a, int b) {
        return a + b;
    }
}

public class CalculatorSteps {
    private int firstNumber;
    private int secondNumber;
    private int result;

    @Дано("первое число равно {int}")
    public void первое_число_равно(int number) {
        this.firstNumber = number;
    }

    @Дано("второе число равно {int}")
    public void второе_число_равно(int number) {
        this.secondNumber = number;
    }

    @Когда("пользователь выполняет операцию сложения")
    public void пользователь_выполняет_операцию_сложения() {
        this.result = Calculator.add(firstNumber, secondNumber);
    }

    @Тогда("результат равен {int}")
    public void результат_равен(int expectedResult) {
        assertThat(result).isEqualTo(expectedResult);
    }
}