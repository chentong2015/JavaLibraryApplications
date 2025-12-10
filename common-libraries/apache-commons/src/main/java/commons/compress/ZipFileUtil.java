package commons.compress;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// TODO. 本质上只需操作ZipArchive压缩文件和其中每个ZipArchiveEntry文件
public class ZipFileUtil {

    public static void main(String[] args) throws IOException {
        // 压缩前确保结果目录存在
        Path srcFile = Paths.get("common-libraries/apache-commons/workfolder");
        Path zipFile = Paths.get("common-libraries/apache-commons/workzip/archive.zip");

        try (ZipArchiveOutputStream zipOut = new ZipArchiveOutputStream(Files.newOutputStream(zipFile))) {
            File src = srcFile.toFile();
            if (src.isDirectory()) {
                zipDirectory(zipOut, src, src.getName() + File.separator);
            } else {
                zipSingleFile(zipOut, src, "");
            }
            zipOut.finish();
        }
        System.out.println("Zip created successfully.");
    }

    // TODO. 递归压缩目录中每一个文件
    private static void zipDirectory(ZipArchiveOutputStream zipOut, File folder, String baseName) throws IOException {
        File[] children = folder.listFiles();
        if (children == null) {
            return;
        }
        for (File child : children) {
            if (child.isDirectory()) {
                zipDirectory(zipOut, child, baseName + child.getName() + File.separator);
            } else {
                zipSingleFile(zipOut, child, baseName);
            }
        }
    }

    // 创建entry对应每一个压缩文件, 并拷贝文件数据
    private static void zipSingleFile(ZipArchiveOutputStream zipOut, File file, String baseName) throws IOException {
        ZipArchiveEntry entry = new ZipArchiveEntry(file, baseName + file.getName());
        zipOut.putArchiveEntry(entry);
        try (FileInputStream fis = new FileInputStream(file)) {
            IOUtils.copy(fis, zipOut);
        }
        zipOut.closeArchiveEntry();
    }
}
