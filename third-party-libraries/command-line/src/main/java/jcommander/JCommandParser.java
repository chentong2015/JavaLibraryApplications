package jcommander;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.text.MessageFormat;

@Parameters(separators = "=")
public class JCommandParser {

    private static final String V = "-v";
    private static final String VERSION = "-version";

    private static final String O = "-o";
    private static final String OPTIONS = "-options";

    private static final String E = "-e";
    private static final String ENCRYPT = "-encrypt";

    private static final String APP_NAME_INFO_MSG = "java -jar {0}.jar";

    @Parameter(names = {O, OPTIONS}, validateWith = FileLocationValidator.class, description = "Use the specified file")
    private String outputLocation;

    @Parameter(names = {E, ENCRYPT}, validateWith = EncryptValidator.class, description = "Encrypt the password")
    private String passwordOriginal;

    @Parameter(names = {V, VERSION}, description = "Print product information.")
    private boolean isVersion;

    public void parse(String[] args) {
        JCommander jCommander = new JCommander(this);
        jCommander.setProgramName(MessageFormat.format(APP_NAME_INFO_MSG, "name"));

        jCommander.parse(args);
        System.out.println(outputLocation);
        System.out.println(passwordOriginal);
    }
}
