// Реализуйте очередь с помощью LinkedList

import java.util.LinkedList;

public class task2 {
    private LinkedList<Integer> queue;

    public task2() {
        queue = new LinkedList<>();
    }

    // Добавление элемента в конец очереди
    public void enqueue(int element) {
        queue.addLast(element);
    }

    // Извлечение и удаление первого элемента из очереди
    public int dequeue() {
        return queue.removeFirst();
    }

    // Получение первого элемента из очереди без его удаления
    public int first() {
        return queue.getFirst();
    }

    // Получение содержимого очереди в виде строки
    public String toString() {
        return queue.toString();
    }

    public static void main(String[] args) {
        task2 queue = new task2();

        // Добавляем элементы в очередь
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Выводим содержимое очереди
        System.out.println("Содержимое очереди: " + queue);

        // Выводим первый элемент
        int firstElement = queue.first();
        System.out.println("Первый элемент: " + firstElement);

        // Извлекаем элемент из очереди и выводим его
        int dequeuedElement = queue.dequeue();
        System.out.println("Извлеченный элемент: " + dequeuedElement);

        // Выводим содержимое очереди после извлечения
        System.out.println("Содержимое очереди после извлечения: " + queue);
    }
}
