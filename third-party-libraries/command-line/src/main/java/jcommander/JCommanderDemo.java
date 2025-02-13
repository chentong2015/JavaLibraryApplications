package jcommander;

public class JCommanderDemo {

    // Usage: java -jar name.jar [options]
    //  Options:
    //    -e, -encrypt
    //      Use the specified file
    //    -o, -options
    //      Use the specified file
    //    -v, -version
    //      Print product information.
    //      Default: false
    public static void main(String[] args) {
        JCommandParser commandParser = new JCommandParser();
        commandParser.parse(args);
    }
}
