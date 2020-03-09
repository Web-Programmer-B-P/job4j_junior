package ru.job4j.io.criteria.model;

/**
 * Class Args
 *
 * @author Petr B.
 * @since 05.11.2019, 19:29
 */
public class Args {
    private final String directory;
    private final String name;
    private final String mask;
    private final String targetPath;

    public Args(final String dir, final String n, final String m, final String target) {
        directory = dir;
        name = n;
        mask = m;
        targetPath = target;
    }

    public String getDirectory() {
        return directory;
    }

    public String getName() {
        return name;
    }

    public String getTargetPath() {
        return targetPath;
    }

    public String getMask() {
        return mask;
    }
}
