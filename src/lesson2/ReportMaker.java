package lesson2;

import java.io.IOException;
import java.io.PrintWriter;

public class ReportMaker {
    public static void makeReportPDF(String str, String path) throws IOException{
        PrintWriter pw = null;
            pw = new PrintWriter(path);
            pw.println(str);
            pw.close();
    }
}
