package lesson2;

class MyException extends RuntimeException{
  MyException(String message) {
      super(message);
  }
}

class MyArraySizeException extends IndexOutOfBoundsException {
  MyArraySizeException(int i, int j, int size){
    super(String.format("Задан неверный размер массива: %dx%d. Допустимый размер: %3$dх%3$d.", i, j, size));
  }
}

class MyArrayDataException extends ArrayStoreException {
  MyArrayDataException(int i, int j, String msg){
    super(String.format("Ячейка %d:%d содержит неверные данные: %s", i, j, msg));
  }
}