package commons;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ApacheCommonsIO {

    // TODO. FileUtils: 对于IO文件的操作
    public static void main(String[] args) {

    }

    // TODO. IOUtils: 对于IO Stream流操作，转换成String字符串
    private static void testCommonsIOUtils(InputStream inputStream) throws IOException {
        byte[] bytes = IOUtils.toByteArray(inputStream);
        String str1 = new String(bytes);

        // 以下两种方式效果一致，性能也几乎一致
        String str2 = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer, Charset.defaultCharset());
        String str3 = writer.toString();
    }
}
