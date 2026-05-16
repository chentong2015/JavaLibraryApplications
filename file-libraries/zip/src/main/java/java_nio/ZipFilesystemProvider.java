package java_nio;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ZipFilesystemProvider {

    // Zip文件系统的根目录
    private static final String ROOT_FOLDER = "/";

    // TODO. 自定义创建新zip文件系统，并添加入特定文件
    public static void createZipFilesystems() throws IOException {
        Map<String, String> env = new HashMap<>();
        env.put("create", "true");

        Path externalFile = Paths.get("./file-processing-libraries/zip/workfolder/outer.txt");
        Path zipPath = FileSystems.getDefault().getPath("file-processing-libraries", "zip", "test", "test_new.zip");

        try (FileSystem fs = FileSystems.newFileSystem(zipPath, env)) {
            Path pathInZip = fs.getPath("/new.txt");
            Files.copy(externalFile, pathInZip, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    // TODO. 打开已经存在的Zip文件并添加新的文件
    public static void openZipFilesystemsAndAddNewFile() throws IOException {
        Path zipPath = FileSystems.getDefault().getPath("file-processing-libraries", "zip", "test", "test.zip");
        Path newfilePath = FileSystems.getDefault().getPath("file-processing-libraries", "zip", "test", "target", "new.txt");

        try (FileSystem fs = FileSystems.newFileSystem(zipPath)) {
            Path folderInZip = fs.getPath("/folder");
            Files.createDirectory(folderInZip);

            Path filePathInZip = fs.getPath("/folder/new.txt");
            Files.copy(newfilePath, filePathInZip, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    // TODO. 打开已经存在的Zip文件并读取文件中内容
    public static void openZipFilesystemsAndRead() throws IOException {
        Path zipPath = FileSystems.getDefault().getPath("file-processing-libraries", "zip", "tets", "test.zip");
        try (FileSystem fs = FileSystems.newFileSystem(zipPath)) {
            try (Stream<Path> pathList = Files.walk(fs.getPath(ROOT_FOLDER)).map(Path::getFileName)) {
                for (Path path : pathList.toList()) {
                    System.out.println(path.toString());
                }
            }

            Path pathInZip = fs.getPath("/test1.txt");
            String content = Files.readString(pathInZip);
            System.out.println(content);
        }
    }
}
