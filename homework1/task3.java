package homework1;
// Реализовать простой калькулятор

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int num1 = scan.nextInt();
        System.out.print("Введите действие: ");
        String operator = scan.next();
        System.out.print("Введите второе число: ");
        int num2 = scan.nextInt();
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
        }
        System.out.printf("%d %s %d = %d", num1, operator, num2, result);
        scan.close();
    }
}