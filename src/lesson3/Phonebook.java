package lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Phonebook {
    private Map<String, Set<String>> records = new HashMap<>();

    void add(String name, String number) {
        records.putIfAbsent(name, new HashSet<>());
        records.get(name).add(number);
    }

    Set<String> get(String name) {
        return records.get(name);
    }
}
