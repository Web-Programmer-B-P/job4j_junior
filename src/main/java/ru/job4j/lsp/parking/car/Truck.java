package ru.job4j.lsp.parking.car;

import ru.job4j.lsp.parking.place.PlaceForTruck;

/**
 * Class Truck
 *
 * @author Petr B.
 * @since 05.12.2019, 13:17
 */
public class Truck extends BaseCar {
    private int load;

    public Truck(String name, String color) {
        super(name, color);
        sizeOfPlaceIntarface = new PlaceForTruck();
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }
}
