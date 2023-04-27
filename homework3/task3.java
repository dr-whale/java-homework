// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

package homework3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class task3 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(7);
        numbers.add(4);
        numbers.add(9);
        numbers.add(2);
        numbers.add(5);
        numbers.add(1);
        numbers.add(8);
        
        System.out.println("List: " + numbers);
        
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);
        
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        double avg = sum / numbers.size();
        
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Avg: " + avg);
    }
}
