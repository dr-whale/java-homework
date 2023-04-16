package homework1;
// Вывести все простые числа от 1 до 1000

import java.math.BigInteger;

public class task2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            BigInteger bigInteger = BigInteger.valueOf(i);
            if (bigInteger.isProbablePrime((int) Math.log(i))) {
                System.out.print(i + " ");
            };
        }
    }
}

