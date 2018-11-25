package lesson1.exceptions;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(int i, int k) {
        super("Value at " + i + ":" + k + " is not int");
    }
}
