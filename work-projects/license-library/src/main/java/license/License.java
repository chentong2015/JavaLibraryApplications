package license;

import java.time.LocalDate;

public class License {

    private String productVersion;
    private String key;
    private String value;
    private LocalDate date;

    public License() {
    }

    public License(String productVersion, String key, String value, LocalDate date) {
        this.productVersion = productVersion;
        this.key = key;
        this.value = value;
        this.date = date;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
