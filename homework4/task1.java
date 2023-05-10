// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернёет «перевёрнутый» список.

import java.util.LinkedList;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {
        // Создаем случайный связанный список длиной 7
        LinkedList<Integer> list = generateRandomLinkedList(7);
        
        System.out.println("Исходный список: " + list);
        
        LinkedList<Integer> reversedList = reverseLinkedList(list);
        
        System.out.println("Перевернутый список: " + reversedList);
    }
    
    public static LinkedList<Integer> generateRandomLinkedList(int length) {
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();
        
        for (int i = 0; i < length; i++) {
            list.add(random.nextInt(100)); // Генерация случайного числа от 0 до 99
        }
        
        return list;
    }
    
    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> reversedList = new LinkedList<>();
        
        // Обходим исходный список в обратном порядке и добавляем элементы в новый список
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        
        return reversedList;
    }
}
