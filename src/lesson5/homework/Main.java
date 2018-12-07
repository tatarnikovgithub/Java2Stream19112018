package lesson5.homework;

import java.util.Arrays;

public class Main {
    final static int SIZE = 10_000_000;
    public static void main(String[] args){
        singleThread();
        multiThreading();
    }
    public static void singleThread(){
        float[] array = new float[SIZE];
        Arrays.fill(array, 1f);
        long time1 = System.currentTimeMillis();
        calculate(array, 0);
        long time2 = System.currentTimeMillis();
        System.out.println("single thread: " + (time2 - time1));
    }
    public static void multiThreading(){
        float[] array = new float[SIZE];
        Arrays.fill(array, 1f);
        int half = SIZE/2;

        float[] firstHalf = new float[half];
        float[] secondHalf = new float[half];


        long time1 = System.currentTimeMillis();
        System.arraycopy(array, 0, firstHalf, 0, half);
        System.arraycopy(array, half, secondHalf, 0, half);


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run(){
                calculate(firstHalf, 0);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run(){
                calculate(secondHalf, half);
            }
        });
        try{
            thread1.start();
            thread2.start();
            System.arraycopy(firstHalf, 0, array, 0, half);
            System.arraycopy(secondHalf, 0, array, half, half);
            thread1.join();
            thread2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        long time2 = System.currentTimeMillis();
        System.out.println("Multithreading: " + (time2 - time1));
    }
    public static void calculate(float[] array, int offset){
        for(int i = 0; i < array.length; i++){
            int j = offset + i;
            array[i] = (float) (array[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
    }
}
