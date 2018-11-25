package lesson2.DZ_2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(){
        super("Размерность двумерного массива не равна 4x4");
    }
}
