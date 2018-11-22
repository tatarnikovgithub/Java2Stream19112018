package lesson2;

public class MainClass {
    public static void main(String[] args) {
        throw new MyException("Сгенерировано исключение");
    }


//    static class Person {
//        int age;
//
//        public Person(int age) {
//            this.age = age;
//            if (age < 14) throw new RuntimeException("Невозможно создать сотрудника с возраcтом меньше 14");
//        }
//    }
//
//    public static void main(String[] args) {
//        Person p = new Person(5);
//        System.out.println(p.age);
//
//    }

//    public static void main(String[] args) {
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream("1.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        // try-with-resources
//        try(FileOutputStream out2 = new FileOutputStream("2.txt"); FileOutputStream out3 = new FileOutputStream("3.txt")){
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        try{
//
//        }catch (ArithmeticException| NullPointerException| NumberFormatException e){
//
//        }


//        JFrame jf = new JFrame();
//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jf.setTitle("Report Maker");
//        jf.setBounds(1200, 400, 400, 400);
//        JButton jButton = new JButton("Save Report");
//        jButton.addActionListener(e -> {
//            try {
//                ReportMaker.makeReportPDF("Report1", "Z:/1.pdf");
//            } catch (IOException e1) {
//                JOptionPane.showMessageDialog(null, "Ошибка при сохранении отчета!");
//            }
//        });
//        jf.add(jButton, BorderLayout.SOUTH);
//        jf.setVisible(true);

//        try {
//            a();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void a() throws IOException{
//        FileOutputStream out = new FileOutputStream("1.txt");
//        out.close();
//    }
    }
//}


//    public static void main(String[] args) {
// try, catch, finally, throw, throws
//        System.out.println(sqrt(-10));
//    }
//
//    public static int sqrt(int n){
//        if (n>=0){
//            return n / 2;
//        }
//        throw new ArithmeticException("Невозможно взять квадратный корень из отрицательного числа!");
//    }
//}
