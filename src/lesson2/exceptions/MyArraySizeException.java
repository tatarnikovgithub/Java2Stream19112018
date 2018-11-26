package lesson2.exceptions;

public class MyArraySizeException extends RuntimeException {
    private static final String ARRAY_SIZE_EXCEPTION_MESSAGE = "Array dimension is not supported";

    public MyArraySizeException() {
        super(ARRAY_SIZE_EXCEPTION_MESSAGE);
    }
}
