package commons.configuration;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.builder.fluent.PropertiesBuilderParameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// TODO. 支持读取同一个Key的多个Value值
// PropertiesConfiguration supports loading a properties file with multiple entries with same key
public class CommonsConfigFile {

    private static String fileLocation = "duplicateParams.cfg";

    public static void main(String[] args) throws ConfigurationException {
        PropertiesBuilderParameters parameters = new Parameters().properties();
        parameters.setFileName(fileLocation);

        Configuration configuration = new FileBasedConfigurationBuilder<>(PropertiesConfiguration.class)
                .configure(parameters)
                .getConfiguration();
        Iterator<String> keyIterator = configuration.getKeys();

        // 迭代读取的属性中是存在一个key对应多个value的情况
        List<String> duplicatedParameters = new ArrayList<>();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            String[] stringArray = configuration.getStringArray(key);
            if (stringArray.length > 1) {
                duplicatedParameters.add(key);
                duplicatedParameters.add(stringArray[0]);
                duplicatedParameters.add(stringArray[1]);
            }
        }
        for (String param: duplicatedParameters) {
            System.out.println(param);
        }
    }
}
