package csv;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvWriterPrint {

    // File项目文件路径
    private static String fileName = "test.csv";
    private static String lineSeparator = System.getProperty("line.separator");

    public static void main(String[] args) throws FileNotFoundException {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            printWriter.write(getCsvString());
            printWriter.println("100,test");

            printWriter.flush();
        }
    }

    private static String getCsvString() {
        StringBuilder sb = new StringBuilder();
        // add csv title and data
        sb.append("id").append(',').append("Name").append(lineSeparator);
        sb.append("10").append(',').append("Chen").append(lineSeparator);
        sb.append("100").append(',').append("Victor").append(lineSeparator);
        return sb.toString();
    }
}
