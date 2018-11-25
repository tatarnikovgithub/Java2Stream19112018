package lesson1;

import lesson1.Competitors.Cat;
import lesson1.Competitors.Dog;
import lesson1.Competitors.Human;
import lesson1.Competitors.Team;
import lesson1.exceptions.MyArrayDataException;
import lesson1.exceptions.MyArraySizeException;
import lesson1.obstacles.Course;
import lesson1.obstacles.Cross;
import lesson1.obstacles.Wall;
import lesson1.obstacles.Water;

public class MainClass {
    public static void main(String[] args) {


        //this will throw MyArraySizeException
        //Object[][] array = {{1, 2, 3, 4}, {1, 2, 3}, {1, 2, 3, 4}, {1, 2, 3, 4}};

        //this will throw MyArrayDataException
        //Object[][] array = {{1, 'a', 3, 4}, {1, 2, 3, 'b'}, {1, 2, 3, 4}, {1, 2, 3, 4}};

        //this will work fine
        Object[][] array = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};


        try {
            System.out.println(checkArray(array));
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.toString());
        }

    }

    public static int checkArray(Object[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (Object[] subarray : array) {
            if (subarray.length != 4) {
                throw new MyArraySizeException();
            }
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 4; k++) {
                try {
                    sum += (int) array[i][k];
                } catch (NullPointerException | ClassCastException e) {
                    throw new MyArrayDataException(i, k);
                }
            }
        }
        return sum;
    }
}
