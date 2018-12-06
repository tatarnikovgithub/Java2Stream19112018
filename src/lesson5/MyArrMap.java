package lesson5;

class MyArrMap {
  private static final int size = 10_000_000;
  private static final int h = size / 2;

  static void mapInOneThread(float[] floats) {
    long a = System.currentTimeMillis();

    mapArray(floats);

    System.out.printf("mapInOneTread%nsize: %,d, time: %d ms%n", size, System.currentTimeMillis() - a);
  }

  static void mapInTwoThread(float[] floats) throws InterruptedException {
    long a = System.currentTimeMillis();

    float[] floats1 = new float[h];
    float[] floats2 = new float[h];

    System.arraycopy(floats,0, floats1,0, h);
    System.arraycopy(floats, h, floats2,0, h);

    Thread t1 = new Thread(() -> {
      mapArray(floats1);
    });
    Thread t2 = new Thread(() -> {
      mapArray(floats2);
    });

    t1.start();
    t2.start();
    t1.join();
    t2.join();

    System.arraycopy(floats1, 0, floats, 0, h);
    System.arraycopy(floats2, 0, floats, h, h);

    System.out.printf("mapInTwoTread%nsize: %,d, time: %d ms%n", size, System.currentTimeMillis() - a);
  }

  static float[] fillArray(float fill) {
    float[] arr = new float[size];

    for (int i = 0; i < arr.length; i++){
      arr[i] = fill;
    }

    return arr;
  }

  private static void mapArray(float[] floats){
    for (int i = 0; i < floats.length; i++){
      floats[i] =
          (float)(
              floats[i] * Math.sin(0.2f + i / 5f) * Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f)
          );
    }
  }
}
