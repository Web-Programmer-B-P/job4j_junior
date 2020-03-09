package ru.job4j.isp.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class Menu
 *
 * @author Petr B.
 * @since 05.12.2019, 16:21
 */
public class Menu {
    private String name;
    private ArrayList<Menu> childMenu;

    public Menu(String name) {
        this.name = name;
    }

    public Menu(String name, ArrayList<Menu> childMenu) {
        this.name = name;
        this.childMenu = childMenu;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Menu> getListOfChildren() {
        return childMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return Objects.equals(name, menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
