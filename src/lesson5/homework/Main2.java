package lesson5.homework;

import java.util.Arrays;

public class Main2 {
    final static int SIZE = 10_000_000;
    final static int THREADS_COUNT = 2;
    final static int PART_SIZE = SIZE/THREADS_COUNT; //сколько элементов мы отдаем каждому потоку
    public static void main(String[] args){
        float[] array = new float[SIZE];
        Arrays.fill(array, 1f);
        long a = System.currentTimeMillis();
        float[][] m = new float[THREADS_COUNT][PART_SIZE];
        Thread[] t = new Thread[THREADS_COUNT];
        for(int i = 0; i < THREADS_COUNT; i++){
            System.arraycopy(array, PART_SIZE*i, m[i], 0, PART_SIZE);
            final int u = i;
            t[i] = new Thread(new Runnable() {
                @Override
                public void run(){
                    for(int j = 0, z=u*PART_SIZE; j < PART_SIZE; j++, z++){
                        m[u][j] = (float)(m[u][j] * Math.sin(0.2f + z/5) * Math.cos(0.2f + z/5) * Math.cos(0.4f + z/2));
                    }
                }
            });
            t[i].start();
        }
        for(int i = 0; i < THREADS_COUNT; i++){
            try{
                t[i].join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        for(int i = 0; i < THREADS_COUNT; i++){
            System.arraycopy(m[i], 0, array, i*PART_SIZE, PART_SIZE);
        }
        System.out.println(System.currentTimeMillis() - a);
    }
}
