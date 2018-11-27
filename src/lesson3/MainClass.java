package lesson3;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {

        String[] words = {"собака", "колесо", "мяч", "фонарик", "мяч", "доска", "телевизор", "собака", "мяч", "человек",
                "дом", "год", "число", "монета", "человек", "доска", "мяч", "луч", "мяч", "собака"};

        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            if (wordCount.containsKey(w)) {
                wordCount.put(w, wordCount.get(w) + 1);
            } else {
                wordCount.put(w, 1);
            }
        }

        wordCount
                .entrySet()
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));


        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "980-789-145");
        phoneBook.add("Петров", "897-463-134");
        phoneBook.add("Сидоров", "748-712-890");
        phoneBook.add("Иванов", "673-123-867");
        phoneBook.add("Сидоров", "984-653-019");
        phoneBook.add("Иванов", "347-019-311");
        phoneBook.add("Иванов", "874-091-234");
        phoneBook.add("Петров", "983-123-089");
        phoneBook.add("Петров", "982-123-345");

        System.out.println("Иванов:");
        phoneBook.get("Иванов").forEach(s -> System.out.println(s));

        System.out.println("Петров:");
        phoneBook.get("Петров").forEach(s -> System.out.println(s));

        System.out.println("Сидоров:");
        phoneBook.get("Сидоров").forEach(s -> System.out.println(s));
    }
}
