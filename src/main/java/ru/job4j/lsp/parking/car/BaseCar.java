package ru.job4j.lsp.parking.car;

import ru.job4j.lsp.parking.interfaces.SizeOfPlaceIntarface;

/**
 * Class BaseCar
 *
 * @author Petr B.
 * @since 05.12.2019, 13:13
 */
abstract public class BaseCar {
    private final String name;
    private final String color;
    protected SizeOfPlaceIntarface sizeOfPlaceIntarface;

    public BaseCar(final String name, final String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getSizeOfPlace() {
        return sizeOfPlaceIntarface.getSizeOfSquare();
    }
}
