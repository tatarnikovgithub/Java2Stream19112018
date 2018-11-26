package lesson2;

class MyArrayException extends RuntimeException {
  private int sum;

  MyArrayException(String message, int sum) {
      super(message);
      this.sum = sum;
  }
  int getSum() {
    return sum;
  }
}

//class MyArraySizeException extends IndexOutOfBoundsException {
class MyArraySizeException extends MyArrayException {
  MyArraySizeException(int i, int j, int size, int sum){
    super(String.format("Задан неверный размер массива: %dx%d. Допустимый размер: %3$dх%3$d.", i, j, size), sum);
  }
}

//class MyArrayDataException extends ArrayStoreException {
class MyArrayDataException extends MyArrayException {
  MyArrayDataException(int i, int j, String msg, int sum){
    super(String.format("Ячейка %d:%d содержит неверные данные: %s", i, j, msg), sum);
  }
}
