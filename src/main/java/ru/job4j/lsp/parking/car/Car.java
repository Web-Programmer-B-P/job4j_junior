package ru.job4j.lsp.parking.car;

import ru.job4j.lsp.parking.place.PlaceForCar;

/**
 * Class Car
 *
 * @author Petr B.
 * @since 05.12.2019, 13:17
 */
public class Car extends BaseCar {
    private int passengers;

    public Car(String name, String color) {
        super(name, color);
        sizeOfPlaceIntarface = new PlaceForCar();
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
}
