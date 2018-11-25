package lesson2.DZ_2;

public class MainClass {
    static int n = 4;

    public static void main(String[] args) {
        String userArray[][] = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        System.out.println("Сумма элементов матрицы равна " + myMethod(userArray));
    }

    public static int myMethod(String[][] userArray) {
        int[][] array = new int[n][n];
        if (userArray.length != n)
            throw new MyArraySizeException();
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i].length != n)
                throw new MyArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                try {
                    array[i][j] = Integer.parseInt(userArray[i][j]);
                } catch (RuntimeException e) {
                    throw new MyArrayDataException(i, j);
                }
                sum += array[i][j];
            }
        }
        return sum;
    }
}
