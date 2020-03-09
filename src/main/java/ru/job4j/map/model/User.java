package ru.job4j.map.model;

import java.util.Objects;

/**
 * Class User
 *
 * @author Petr B.
 * @since 13.10.2019, 8:28
 */
public class User {
    private String name;
    private int children;
    private long birthday;


    public User(String name, int children, long birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getChildren() {
        return children;
    }

    public long getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name
                + '\''
                + ", children=" + children
                + ", birthday=" + birthday
                + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && birthday == user.birthday
                && Objects.equals(name, user.name);
    }
}
