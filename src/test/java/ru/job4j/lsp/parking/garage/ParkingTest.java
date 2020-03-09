package ru.job4j.lsp.parking.garage;

import org.junit.Test;
import ru.job4j.lsp.parking.car.Car;
import ru.job4j.lsp.parking.car.Truck;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ParkingTest
 *
 * @author Petr B.
 * @since 05.12.2019, 13:59
 */
public class ParkingTest {
    @Test
    public void whenSendCarInGarrageFalse() {
        Parking garage = new Parking(8);
        Car firstCar = new Car("Toyota", "black");
        Car secondCar = new Car("Bugatti", "yellow");
        garage.sendTransportInParking(firstCar);
        assertThat(garage.sendTransportInParking(secondCar), is(false));
    }

    @Test
    public void whenSendTruckInGarrageOnSmallPlace() {
        Parking garage = new Parking(9);
        Truck truck = new Truck("Scania", "white");
        assertThat(garage.sendTransportInParking(truck), is(false));
    }

    @Test
    public void whenSendBouthInGarrageTrue() {
        Parking garage = new Parking(15);
        Car car = new Car("Mersedes", "red");
        Truck truck = new Truck("Reno", "green");
        assertThat(garage.sendTransportInParking(car), is(true));
        assertThat(garage.sendTransportInParking(truck), is(true));
    }
}