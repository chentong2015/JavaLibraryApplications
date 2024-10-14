package commons.configuration;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

// 直接获取.properties格式的配置文件
public class CommonsConfigProperties {

    public static void main(String[] args) throws ConfigurationException {
        Configurations configs = new Configurations();
        Configuration config = configs.properties(new File("config.properties"));

        System.out.println(config.getString("database.host"));
        System.out.println(config.getInt("database.port"));
    }
}
