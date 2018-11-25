package lesson1.exceptions;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException() {
        super("Size of array are different from 4x4");
    }
}
