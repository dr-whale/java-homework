// Пусть дан произвольный список целых чисел, удалить из него чётные числа

package homework3;

import java.util.ArrayList;
import java.util.List;

public class task2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(7);
        numbers.add(4);
        numbers.add(9);
        numbers.add(2);
        numbers.add(5);
        numbers.add(1);
        numbers.add(8);
        
        System.out.println("Original List: " + numbers);
        
        List<Integer> oddNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 != 0) {
                oddNumbers.add(number);
            }
        }
        
        numbers.clear();
        numbers.addAll(oddNumbers);
        
        System.out.println("List without even numbers: " + numbers);
    }
}
