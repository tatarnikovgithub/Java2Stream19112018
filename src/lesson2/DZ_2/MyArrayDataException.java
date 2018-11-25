package lesson2.DZ_2;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(int x, int y) {
        super(String.format("В ячейке " + x + y + " введены неверные данные"));
    }
}
