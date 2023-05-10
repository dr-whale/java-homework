package homework5;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class task1 {
    private Map<String, List<String>> contacts;

    public task1() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        List<String> phoneNumbers = contacts.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        contacts.put(name, phoneNumbers);
    }

    public List<String> getPhoneNumbers(String name) {
        return contacts.getOrDefault(name, new ArrayList<>());
    }

    public void printNamesByNumberOfPhones() {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(contacts.entrySet());

        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            int numPhones = entry.getValue().size();
            System.out.println(name + " (" + numPhones + " номера)");
        }
    }

    public static void main(String[] args) {
        System.setProperty("console.encoding", "UTF-8");

        task1 phoneBook = new task1();

        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        boolean running = true;

        while (running) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Получить номер(а) по имени контакта");
            System.out.println("3. Вывести имена по количеству номеров");
            System.out.println("0. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем символ новой строки после ввода числа

            switch (choice) {
                case 1:
                    System.out.println("Введите имя контакта:");
                    String name = scanner.nextLine();
                    System.out.println("Введите номер телефона:");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.addContact(name, phoneNumber);
                    System.out.println("Контакт добавлен.");
                    break;
                case 2:
                    System.out.println("Введите имя контакта:");
                    String searchName = scanner.nextLine();
                    List<String> phoneNumbers = phoneBook.getPhoneNumbers(searchName);
                    if (phoneNumbers.isEmpty()) {
                        System.out.println("Контакт не найден.");
                    } else {
                        System.out.println("Номера телефонов для контакта \"" + searchName + "\":");
                        for (String number : phoneNumbers) {
                            System.out.println(number);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Имена контактов в порядке убывания количества номеров:");
                    phoneBook.printNamesByNumberOfPhones();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Некорректный выбор.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
}
