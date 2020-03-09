package ru.job4j.generic.model;

/**
 * Class Base
 *
 * @author Petr B.
 * @since 06.10.2019, 13:51
 */
public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
