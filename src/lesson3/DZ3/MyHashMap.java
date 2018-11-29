package lesson3.DZ3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyHashMap {
    private HashMap<String, Integer> hm;

    public MyHashMap(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Размерность хеш-отображения не может быть отрицательной");
        hm = new HashMap(n);
    }

    public void myMethod(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (Map.Entry<String, Integer> entry : hm.entrySet()) {
                if (entry.getKey() == arr[i]) {
                    int j = entry.getValue();
                    entry.setValue(j + 1);
                    break;
                }
            }
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], 1);
        }
    }

    public void printHashMap(){
        Iterator<Map.Entry<String, Integer>> iter = hm.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Integer> e = iter.next();
            System.out.println("Строка " + e.getKey() + " встречается  " + e.getValue() + " раз");
        }
    }
}
