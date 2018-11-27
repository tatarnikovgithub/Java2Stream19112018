package lesson3;

import java.util.*;

public class PhoneBook {

    private Map<String, Set<String>> abonentsAndPhones = new HashMap<>();

    public void add(String abonent, String number) {
        if (abonentsAndPhones.containsKey(abonent)) {
            abonentsAndPhones.get(abonent).add(number);
        } else {
            Set<String> numbers = new HashSet<>();
            numbers.add(number);
            abonentsAndPhones.put(abonent, numbers);
        }
    }

    public Set<String> get(String abonent) {
        if (abonentsAndPhones.containsKey(abonent)) {
            return abonentsAndPhones.get(abonent);
        } else {
            return new HashSet<>();
        }
    }
}
