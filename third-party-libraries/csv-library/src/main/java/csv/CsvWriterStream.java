package csv;

import java.io.*;

public class CsvWriterStream {

    // File项目文件路径
    private static String filePath = "output.csv";
    private static String lineSeparator = System.getProperty("line.separator");

    public static void main(String[] args) {
        try (FileOutputStream outputStream = new FileOutputStream(filePath);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream)) {

            StringBuilder sbContent = new StringBuilder();
            sbContent.append("\"\"\"").append("first item ") // 使用""**""双双引号来包含字符串中双引号
                    .append("\"\"\"").append(",")
                    .append("\"second item\"").append(",")
                    .append(" block1 \r\n block2").append(",")   // windows平台的自动换行
                    .append(" block3 \\r\\n block4").append(",") // 将自动换行显示出来
                    .append("end item")
                    .append(lineSeparator);
            byte[] bytes = sbContent.toString().getBytes();

            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
