package ru.job4j.lsp.parking.garage;

import ru.job4j.lsp.parking.car.BaseCar;
import ru.job4j.lsp.parking.interfaces.ParkingInterface;

/**
 * Class Parking
 *
 * @author Petr B.
 * @since 05.12.2019, 13:28
 */
public class Parking implements ParkingInterface {
    private int commonSpaceForTransport;

    public Parking(int squareForGarageInMeters) {
        this.commonSpaceForTransport = squareForGarageInMeters;
    }

    @Override
    public boolean sendTransportInParking(BaseCar baseCar) {
        boolean res = false;
        if (baseCar.getSizeOfPlace() <= commonSpaceForTransport) {
            commonSpaceForTransport -= baseCar.getSizeOfPlace();
            res = true;
        }
        return res;
    }
}
