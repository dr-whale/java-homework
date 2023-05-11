package homework6;

import java.util.*;
import java.util.stream.Collectors;

public class task {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Dell XPS 13", 8, 256, "Windows", "Silver"));
        laptops.add(new Laptop("MacBook Pro", 32, 512, "macOS", "Space Gray"));
        laptops.add(new Laptop("Lenovo ThinkPad X1 Carbon", 16, 1024, "Linux", "Black"));

        Map<String, Object> filters = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объём ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criteria = scanner.nextInt();

        switch (criteria) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ:");
                int minRam = scanner.nextInt();
                filters.put("ram", minRam);
                break;
            case 2:
                System.out.println("Введите минимальное значение объема жесткого диска:");
                int minStorage = scanner.nextInt();
                filters.put("storage", minStorage);
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.next();
                filters.put("os", os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.next();
                filters.put("color", color);
                break;
            default:
                System.out.println("Неверный критерий фильтрации.");
                return;
        }

        filterLaptops(laptops, filters);
    }

    public static void filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
        List<Laptop> filteredLaptops = new ArrayList<>(laptops);

        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            switch (key) {
                case "ram":
                    int ram = (int) value;
                    filteredLaptops = filteredLaptops.stream()
                            .filter(laptop -> laptop.getRam() >= ram)
                            .collect(Collectors.toList());
                    break;
                case "storage":
                    int storage = (int) value;
                    filteredLaptops = filteredLaptops.stream()
                            .filter(laptop -> laptop.getStorage() >= storage)
                            .collect(Collectors.toList());
                    break;
                case "os":
                    String os = (String) value;
                    filteredLaptops = filteredLaptops.stream()
                            .filter(laptop -> laptop.getOs().equalsIgnoreCase(os))
                            .collect(Collectors.toList());
                    break;
                case "color":
                    String color = (String) value;
                    filteredLaptops = filteredLaptops.stream()
                            .filter(laptop -> laptop.getColor().equalsIgnoreCase(color))
                            .collect(Collectors.toList());
                    break;
                default:
                    System.out.println("Invalid filter key: " + key);
                    break;
            }
        }

        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop.getModel() + ", " + laptop.getRam() + "GB RAM, " +
                    laptop.getStorage() + "GB storage, " + laptop.getOs() + ", " + laptop.getColor());
        }
    }
}

class Laptop {
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Laptop(String model, int ram, int storage, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }
}
