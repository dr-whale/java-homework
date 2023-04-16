package homework1;
// Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Введите число N: ");
        int n = scan.nextInt();
        int triangle = (n * (n + 1)) / 2;
        System.out.printf("Треугольное число: " + triangle);
        scan.close();
    }
}