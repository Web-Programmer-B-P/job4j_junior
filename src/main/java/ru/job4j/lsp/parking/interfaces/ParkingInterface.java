package ru.job4j.lsp.parking.interfaces;

import ru.job4j.lsp.parking.car.BaseCar;

/**
 * Class ParkingInterface
 *
 * @author Petr B.
 * @since 05.12.2019, 13:24
 */
public interface ParkingInterface {
    boolean sendTransportInParking(BaseCar baseCar);
}
