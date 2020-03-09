package ru.job4j.io.zip.parse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Args
 *
 * @author Petr B.
 * @since 28.10.2019, 19:36
 */
public class Args {
    private String[] arguments;
    private String directory;
    private String exclude;
    private String output;

    public Args(String[] args) {
        arguments = args;
        init();
    }

    public String getDirectory() {
        return directory;
    }

    public String getExclude() {
        return exclude;
    }

    public String getOutput() {
        return output;
    }

    public void init() {
        Pattern patternDir = Pattern.compile("(/?[a-z_0-9]/?)+");
        Pattern patternExclude = Pattern.compile("(\\*[.a-z]+)");
        Pattern patternOutPut = Pattern.compile("[a-z.0-9]+");
        for (int index = 0; index < arguments.length; index++) {
            String arg = arguments[index];
            Matcher dir = patternDir.matcher(arg);
            Matcher exc = patternExclude.matcher(arg);
            Matcher out = patternOutPut.matcher(arg);
            if (dir.matches()) {
                directory = arg;
            }
            if (exc.matches()) {
                exclude = arg.substring(1);
            }
            if (out.matches()) {
                output = arg;
            }
        }
    }
}
