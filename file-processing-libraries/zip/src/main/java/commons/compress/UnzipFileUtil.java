package commons.compress;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Enumeration;

public class UnzipFileUtil {

    public static void main(String[] args) throws IOException {
        File zipFile = new File("file-processing-libraries/zip/workzip/archive.zip");
        File targetDir = new File("file-processing-libraries/zip/workunzip");
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }
        unzip(zipFile, targetDir);
        System.out.println("Unzip completed.");
    }

    // TODO. 遍历ZipFile文件中每个ZipArchiveEntry文件
    public static void unzip(File zipFile, File targetDir) throws IOException {
        // 指定UTF-8防止中文文件名乱码
        try (ZipFile zip = ZipFile.builder().setFile(zipFile)
                .setCharset(java.nio.charset.StandardCharsets.UTF_8).get()) {
            Enumeration<ZipArchiveEntry> entries = zip.getEntries();
            while (entries.hasMoreElements()) {
                ZipArchiveEntry entry = entries.nextElement();
                File outFile = new File(targetDir, entry.getName());

                // 防止Zip Slip漏洞
                Path normalizedPath = outFile.toPath().normalize();
                if (!normalizedPath.startsWith(targetDir.toPath())) {
                    throw new IOException("Bad zip entry: " + entry.getName());
                }
                unzipSingleFile(zip, entry, outFile);
            }
        }
    }

    // 创建目录或从zip文件中拷贝数据到结果文件
    private static void unzipSingleFile(ZipFile zip, ZipArchiveEntry entry, File outFile) throws IOException {
        if (entry.isDirectory()) {
            Files.createDirectories(outFile.toPath());
        } else {
            Files.createDirectories(outFile.getParentFile().toPath());
            try (InputStream in = zip.getInputStream(entry);
                 FileOutputStream out = new FileOutputStream(outFile)) {
                IOUtils.copy(in, out);
            }
        }
    }
}
