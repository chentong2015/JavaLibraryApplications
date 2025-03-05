package license;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class LicenseLocator {

    private final String licenseFilePath;

    public LicenseLocator(String licenseFilePath) {
        this.licenseFilePath = licenseFilePath;
    }

    // 从给定的文件路径下加载License信息
    public License parseLicence() throws IOException {
        Path path = Paths.get(licenseFilePath);
        List<String> lines = Files.readAllLines(path);

        License license = new License();
        for (String line : lines) {
            String[] elements = line.split("=");
            String key = elements[0];
            String value = elements[1];
            switch (key) {
                case "PRODUCT_VERSION" -> license.setProductVersion(value);
                case "FK_EXPIRATION" -> license.setDate(LocalDate.parse(value));
                case "FK_KEY" -> license.setKey(value);
                case "FK_VALUE" -> license.setValue(value);
            }
        }
        return license;
    }
}
