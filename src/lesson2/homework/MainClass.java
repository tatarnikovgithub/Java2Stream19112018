package lesson2.homework;

public class MainClass {
    public static void main(String[] args) {
        String[][] matrix = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String [][] wrongMatrix = {
                {"1", "2"},
                {"5", "6", "7", "8"},
                {"9", "10", "12"},
                {"13", "14", "15", "16"}

        };
        String [][] wrongChar = {
                {"1", "2", "3", "4"},
                {"5", " ", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            System.out.println(Conversation.converter(matrix));
        } catch (MyException e) {
            e.getMessage();
        }
        try {
            System.out.println(Conversation.converter(wrongMatrix));
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
        try {
            System.out.println(Conversation.converter(wrongChar));
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
    }
}
