package lesson5;

public class MainClass {
//    Object mon = new Object();

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {
//        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();
//        t1.start();
//        t2.start();
//
//        Thread t3 = new Thread(new MyRunnable());
//        Thread t4 = new Thread(new MyRunnable());
//        t3.start();
//        t4.start();

//        Thread t1 = new Thread(() -> System.out.println("A"));
//        Thread t2 = new Thread(() -> System.out.println("B"));
//        t1.start();
//        t2.start();

//        ExecutorService service = Executors.newFixedThreadPool(10);
//        service.execute(() -> {
//            System.out.println("A");
//        });
//        service.shutdown();

//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(i);
//            }
//        }).start();

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("A");
//            }
//        });
//        t.setPriority(5);
//        t.start();

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println(i);
//                }
//            };
//        });
//        t.start();
//        try {
//            t.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("end");

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int time = 0;
//                while (true){
//                    time++;
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(time);
//                }
//            }
//        });
//        t.setDaemon(true);
//        t.start();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("end");
//        Counter counter = new Counter();
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    counter.inc();
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    counter.dec();
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
//
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(counter.value());
//        MainClass mc = new MainClass();
//        new Thread(() -> {mc.method1();}).start();
//        new Thread(() -> {mc.method1();}).start();
//    }
//
//    public void method1() {
//        System.out.println("Block1 begin");
//        for (int i = 0; i < 5; i++) {
//            System.out.println(i);
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        }
//        System.out.println("Block1 end");
//        synchronized(mon){
//            System.out.println("Synch block begin");
//            for (int i = 0; i < 5; i++) {
//                System.out.println(i);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            }
//            System.out.println("Synch block end");
//        }
        countInOneThread();
        countInTwoThreads();
    }

    public static void countInOneThread() {

        float[] arr = getArray();

        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long finish = System.currentTimeMillis();

        System.out.println("Count in one thread took " + (finish - start) + " ms.");
    }

    public static void countInTwoThreads() throws InterruptedException {

        float[] arr = getArray();

        long start = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr,0, a1,0, h);
        System.arraycopy(arr, h, a2,0, h);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        long finish = System.currentTimeMillis();

        System.out.println("Count in two threads took " + (finish - start) + " ms.");
    }

    public static float[] getArray() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        return arr;
    }
}

