package common_cli;

import org.apache.commons.cli.*;

// Apache Commons CLI provides a simple API
// for presenting, processing and validating a Command Line Interface.
public class CommandLineParserDemo {

    public static void main(String[] args) throws ParseException {
        Options options = new Options()
                .addOption("u", "username", true, "Username for connection.")
                .addOption("h", "help", false, "Prints this help");

        CommandLineParser parser = new GnuParser();
        CommandLine cmd = parser.parse(options, args, true);

        if (cmd.hasOption("help")) {
            HelpFormatter help = new HelpFormatter();
            help.setWidth(80);
            help.printHelp("Command line help: ", options);
            return;
        }
        String username = cmd.getOptionValue("username");
        System.out.println(username);
    }

    static String getMandatoryOptionValue(final CommandLine cmd, final String name) {
        final String value = cmd.getOptionValue(name);
        if (value == null) {
            throw new RuntimeException(String.format("'%s' is missing use --help for help", name));
        }
        return value;
    }
}
