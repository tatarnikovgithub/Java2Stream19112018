package lesson3.DZ3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//import java.util.LinkedList;

public class MyPhoneBook {
    private HashMap<String, ArrayList<String>> hm;

    public MyPhoneBook() {
        hm = new HashMap<>();
    }

    public void add(String keySername, String valueNumber) {
        for (Map.Entry<String, ArrayList<String>> entry : hm.entrySet()) {
            if (entry.getKey() == keySername) {
                ArrayList<String> arr = entry.getValue();
                if (arr.contains(valueNumber))
                    System.out.println("Попытка повторно записать " + keySername + " с номером телефона " + valueNumber);
                else
                    arr.add(valueNumber);
                break;
            }
        }
        if (!hm.containsKey(keySername)) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add(valueNumber);
            hm.put(keySername, arr);
        }
    }

    public void getSername(String sername) {
        if (hm.containsKey(sername))
            System.out.println("Под фамилией: " + sername + " следующие номера:" + hm.get(sername));
        else
            System.out.println("В справочнике абонемент с фамилией " + sername + " не существует!");
    }

    public void printPhoneBookp() {
        Iterator<Map.Entry<String, ArrayList<String>>> iter = hm.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, ArrayList<String>> e = iter.next();
            System.out.println(e.getKey() + " " + e.getValue().toString());
        }
    }

}
