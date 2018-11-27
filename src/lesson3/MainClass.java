package lesson3;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
//        ArrayList<String> ali = new ArrayList<>();
//        ali.add("A");
//        ali.add("C");
//        ali.add("A");
//        ali.add("A");
//        ali.add("B");
//        ali.add("B");
//        System.out.println(ali);
//        ArrayList<String> ali2 = new ArrayList<>();
//        ali2.add("W");
//        ali2.add("W");
//        ali2.add("W");
//        ali2.add("A");
//        ali2.add("B");
//        ali2.add("B");
//        ali.add(2, "D");
//        ali.addAll(1, ali2);
//        System.out.println(ali);
//        HashMap<String, String> hm = new HashMap<>();
//        hm.put("France", "Paris");
//        hm.put("Russia", "Moscow");
//        hm.put("England", "London");
//        System.out.println(hm.get("France"));
//        System.out.println(hm.get("England"));

////        ArrayList<String> al = new ArrayList<>();
////        for (int i = 0; i < 1_000_000; i++) {
////            al.add("Entry #" + i);
////        }
//
//        HashMap<String, Integer> hm = new HashMap<>();
//        for (int i = 0; i < 1_000_000; i++) {
//            hm.put("Entry #" + i, i);
//        }
//        long time = System.currentTimeMillis();
////        for (int i = 0; i < 400; i++) {
////            al.contains("Entry #654882");
////        }
//        for (int i = 0; i < 100_000_000; i++) {
//            hm.get("Entry #654882");
//        }
//        System.out.println(System.currentTimeMillis() - time);
//        String[] str = new String[16];
//        str[(str.length - 1) & "Java".hashCode()] = "Java";
//        str[(str.length - 1) & "Home".hashCode()] = "Home";
//        str[(str.length - 1) & "Core".hashCode()] = "Core";
//        System.out.println(Arrays.toString(str));
//        HashSet<String> hs = new HashSet<>();
//        hs.add("A");
//        hs.add("A");
//        hs.add("A");
//        hs.add("B");
//        hs.add("B");
//        hs.add("C");
//        System.out.println(hs);
//        TreeSet<String> ts = new TreeSet<>(Arrays.asList("A", "W", "W", "Q", "C", "C", "D"));
//        System.out.println(ts);
//        HashMap<String, Integer> hmi = new HashMap<>();
////        hmi.put("A", 1);
//        System.out.println(hmi.getOrDefault("A", 9));

//        ArrayList<Integer> ali = new ArrayList<>(Arrays.asList(2,2,2,1,2,2,1,1));
//        Iterator<Integer> iter = ali.iterator();
//        while(iter.hasNext()){
//            Integer temp = iter.next();
//            if (temp == 2) iter.remove();
//        }
//        System.out.println(ali);

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("A", 1);
        Iterator<Map.Entry<String, Integer>> iter = hm.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Integer> e = iter.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }

    }
}
