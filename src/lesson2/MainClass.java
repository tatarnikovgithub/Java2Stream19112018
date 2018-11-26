package lesson2;

import lesson2.exceptions.MyArrayDataException;
import lesson2.exceptions.MyArraySizeException;

public class MainClass {
    public static void main(String[] args) {

        //test calculateSumArrIsSuccessful
        Object[][] array1 = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        try {
            System.out.println(calculateSumArr(array1));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

        //test calculateSumArrIsMyArraySizeException
        Object[][] array2 = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        try {
            System.out.println(calculateSumArr(array2));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

        //test calculateSumArrIsMyArrayDataExceptionOnFirstPosition
        Object[][] array3 = {{1, 2, 3, 4}, {"a", 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        try {
            System.out.println(calculateSumArr(array3));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static long calculateSumArr(Object[][] multiArray) throws RuntimeException {
        if (multiArray.length != 4) {
            throw new MyArraySizeException();
        }
        for (Object[] array : multiArray) {
            if (array.length != 4) {
                throw new MyArraySizeException();
            }
        }

        long sum = 0;
        for (int firstInd = 0; firstInd < 4; firstInd++) {
            for (int secondInd = 0; secondInd < 4; secondInd++) {
                try {
                    sum += (int) multiArray[firstInd][secondInd];
                } catch (RuntimeException ex) {
                    throw new MyArrayDataException(ex, firstInd, secondInd);
                }
            }
        }

        return sum;
    }
}
