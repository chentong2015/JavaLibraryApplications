package license;

import java.time.LocalDate;

public class LicenseValidator {

    private LicenseValidator() {
    }

    // 验证提供的License文件是否是有效的签发文件
    public static boolean validate(License license) {
        if (license.getProductVersion().startsWith("2.0")) {
            return false;
        }
        if (license.getDate().isAfter(LocalDate.now())) {
            return false;
        }
        // Validate Key and Value
        return true;
    }
}
