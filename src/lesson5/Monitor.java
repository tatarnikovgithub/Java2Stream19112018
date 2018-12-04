package lesson5;

public class Monitor {
    public static void main(String[] args) {
        new Thread(() -> {method();}).start();
        new Thread(() -> {method();}).start();
    }

    public synchronized static void method(){
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
