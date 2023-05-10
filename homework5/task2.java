package homework5;

import java.util.Random;

public class task2 {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Построение max-кучи (максимальная пирамида)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Перестановка элементов пирамиды для получения отсортированного массива
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной пирамиде
            heapify(arr, i, 0);
        }
    }

    // Процедура для перестроения поддерева с корнем i в пирамиде размером n
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int left = 2 * i + 1; // Левый потомок
        int right = 2 * i + 2; // Правый потомок

        // Если левый потомок больше корня
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Если правый потомок больше корня
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Если наибольший элемент не является корнем
        if (largest != i) {
            // Меняем местами корень и наибольший элемент
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно вызываем heapify для затронутого поддерева
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = generateRandomArray(10);
        System.out.println("Исходный массив:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Отсортированный массив:");
        printArray(arr);
    }

    public static int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(100); // Генерируем случайное число от 0 до 99
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
