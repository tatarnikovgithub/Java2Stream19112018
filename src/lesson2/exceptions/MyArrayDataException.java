package lesson2.exceptions;

public class MyArrayDataException extends RuntimeException {
    private static final String ARRAY_DATA_EXCEPTION_MESSAGE = "Array data is not supported";
    private final int firstIndex;
    private final int secondIndex;

    public MyArrayDataException(int firstIndex, int secondIndex) {
        super(ARRAY_DATA_EXCEPTION_MESSAGE);

        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    public MyArrayDataException(Throwable cause, int firstIndex, int secondIndex) {
        super(ARRAY_DATA_EXCEPTION_MESSAGE, cause);

        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    @Override
    public String getMessage() {
        String detailMessage = ": element at [%s][%s]";
        return super.getMessage() + String.format(detailMessage, firstIndex, secondIndex);
    }
}
