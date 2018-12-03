package lesson2.homework;

public class Conversation {
    public static int converter(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (4 != array.length) throw new MyArraySizeException();
        for (int i = 0; i < array.length; i++) {
            if (4 != array[i].length) throw new MyArraySizeException();
            for (int k = 0; k < array[i].length; k++) {
                try {
                    sum += Integer.parseInt(array[i][k]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, k);
                }
            }
        }
        return sum;
    }
}
