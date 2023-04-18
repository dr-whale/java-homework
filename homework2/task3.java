package homework2;
// Реализовать простой калькулятор

import java.util.Scanner;
import java.io.IOException;
import java.util.logging.*;

public class task3 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(task3.class.getName());
        FileHandler fileHandler = new FileHandler("task3.log");
        logger.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        Boolean stop_command = false;
        String switchString;
        Scanner scan = new Scanner(System.in);
        System.out.println("Калькулятор включен");
        logger.info("Calc ON");
        while (stop_command == false) {
            System.out.print("Введите первое число: ");
            int num1 = scan.nextInt();
            logger.info("User entered the first number: " + num1);
            System.out.print("Введите второе число: ");
            int num2 = scan.nextInt();
            logger.info("User entered the second number: " + num2);
            System.out.print("Введите действие: ");
            String operator = scan.next();
            logger.info("User entered the operation: " + operator);
            int result = 0;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            logger.info("Result: " + result);
            System.out.printf("%d %s %d = %d \n", num1, operator, num2, result);
            System.out.print("Введите stop если хотите закончить, что бы продолжить любой символ: ");
            switchString = scan.next();
            if (switchString.equals("stop")) {
                stop_command = true;
                System.out.println("Калькулятор выключен");
                logger.info("Calc OFF");
            }
        }
        scan.close();
    }
}