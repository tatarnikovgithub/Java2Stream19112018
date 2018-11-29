package lesson3;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        List<String> arr = Arrays.asList("Russia", "France", "Russia", "Germany", "Russia");
        Map<String, Integer> arrStatistic = getArrDuplicateStatistic(arr);

        if (arrStatistic.get("Russia") != 3 ||
                arrStatistic.get("France") != 1 ||
                    arrStatistic.get("Germany") != 1
        ) {
            throw new RuntimeException("Test \"getArrDuplicateStatistic\" not passed!");
        }

        Phonebook phonebook = new Phonebook();
        phonebook.add("Vlad","8800222");
        phonebook.add("Sergei","8800444");
        phonebook.add("Vlad","5555555");

        if (phonebook.get("Vlad").size() != 2 ||
                phonebook.get("Sergei").size() != 1 ||
                    phonebook.get("Andry") != null
        ) {
            throw new RuntimeException("Test \"phonebook\" not passed!");
        }
    }

    private static Map<String, Integer> getArrDuplicateStatistic(List<String> arr) {
        if (arr == null || arr.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<String, Integer> result = new HashMap<>();
        for (String item : arr) {
            int count = 0;
            if (result.containsKey(item)) {
                count = result.get(item);
            }
            result.put(item, ++count);
        }
        return result;
    }
}
