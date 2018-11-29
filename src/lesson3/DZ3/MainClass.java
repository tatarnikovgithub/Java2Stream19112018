package lesson3.DZ3;

public class MainClass {
    public static void main(String[] args) {
        //превое задание
        String[] arr = {"AA", "BB", "CC", "DD", "A", "B", "C", "D", "AA", "AA", "BB", "D", "D", "CC", "F", "G"};
        MyHashMap h = new MyHashMap(30);
        h.myMethod(arr);
        h.printHashMap();

        // Второе задание
        System.out.println("======================");

        MyPhoneBook pb = new MyPhoneBook();
        pb.add("Иванов", "01");
        pb.add("Иванов", "02");
        pb.add("Петров", "03");
        pb.add("Петров", "04");
        pb.add("Петров", "04");
        pb.add("Сидоров", "07");

        pb.printPhoneBookp();

        pb.getSername("Иванов");

    }


}
