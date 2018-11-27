package lesson2.homework;

public class MyArrayDataException extends MyException {
    public MyArrayDataException(int row, int column) {
        super(String.format("Неправильный формат в[%d][%d] ", row + 1, column + 1));
    }
}
