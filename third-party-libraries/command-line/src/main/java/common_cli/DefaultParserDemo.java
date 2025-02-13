package common_cli;

import org.apache.commons.cli.*;

public class DefaultParserDemo {

    public static void main(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption(new Option("h", "help", false, "Print for help."));
        options.addOption(new Option("d", "debug", false, "Turn on debug."));
        options.addOption(new Option("e", "encryption", true, "Encrypt the password"));
        options.addOption(new Option("o", "option", true, "Turn on option with argument."));

        DefaultParser parser = DefaultParser.builder()
                .setAllowPartialMatching(true)
                .build();

        CommandLine commandLine = parser.parse(options, args);
        if (commandLine.hasOption("help")) {
            HelpFormatter help = new HelpFormatter();
            help.setWidth(80);
            help.printHelp("Command line help: ", options);
            return;
        }

        if (commandLine.hasOption("debug")) {
            System.out.println("Debug is turn on !");
        }

        // 获取特定参数类型传递的值
        if (commandLine.hasOption("encryption")) {
            String password = commandLine.getOptionValue("encryption");
            System.out.println(password);
        }
    }
}
