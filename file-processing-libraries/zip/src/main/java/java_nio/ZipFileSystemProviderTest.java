package java_nio;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ZipFileSystemProviderTest {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Path zipPath = Paths.get("myData.zip");
        Path jarPath = Paths.get("file-processing-libraries/zip/test/test.jar");
        FileSystem fs = FileSystems.newFileSystem(jarPath, Collections.singletonMap("create", "true"));
        System.out.println(fs.isOpen());
        fs.close();

        final String zipFileName = "file-processing-libraries/zip/test/test.jar";
        final Path path = Paths.get(zipFileName);
        final URI uri = URI.create("jar:" + path.toUri());
        FileSystem fileSystem = FileSystems.newFileSystem(uri, Collections.singletonMap("create", "true"));
        System.out.println(fileSystem);
        fileSystem.close();
    }

    private static void testOpenZip(Path zipPath) throws IOException, URISyntaxException {
        Map<String, String> env = new HashMap<>();
        env.put("capacity", "16G");
        env.put("blockSize", "4k");
        URI uriFs = URI.create("memory:///?name=logfs");
        FileSystem fs = FileSystems.newFileSystem(uriFs, env);

        Map<String, String> properties = new HashMap<>();
        properties.put("create", "true");
        properties.put("encoding", "UTF-8");
        URI uri = new URI("jar:file", zipPath.toUri().getPath(), null);
        FileSystem zipFileSystem = FileSystems.newFileSystem(uri, properties);
    }
}
