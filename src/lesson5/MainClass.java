package lesson5;

public class MainClass {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {
        calculateArrValuesByOneThread();
        calculateArrValuesByTwoThread();
    }

    private static void calculateArrValuesByOneThread() {
        float[] arr = getFilledArr();
        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = calculateNewValue(i, arr[i]);
        }

        long end = System.currentTimeMillis();
        System.out.println("Calculate array values by one thread took " + (end - start) + " ms.");
    }

    private static void calculateArrValuesByTwoThread() throws InterruptedException {
        float[] arr = getFilledArr();
        long start = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr,0, a1,0, h);
        System.arraycopy(arr, h, a2,0, h);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = calculateNewValue(i, a1[i]);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = calculateNewValue(i, a2[i]);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        long end = System.currentTimeMillis();
        System.out.println("Calculate array values by two thread took " + (end - start) + " ms.");
    }

    private static float calculateNewValue(int i, float element) {
        return (float)(element * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    private static float[] getFilledArr() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        return arr;
    }
}

