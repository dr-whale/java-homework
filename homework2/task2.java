package homework2;

// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class task2 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(task2.class.getName());
        FileHandler fh = new FileHandler("task2.log");
        logger.addHandler(fh);
        int[] array = {2, 5, 1, -7, 3, 64, 0};

        logger.info("start sort");
        for(int k = 0; k < array.length-1; k++) {
            for (int i = 0; i < array.length - k-1; i++){
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    logger.info(Arrays.toString(array));
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
