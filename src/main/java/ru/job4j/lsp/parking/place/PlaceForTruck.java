package ru.job4j.lsp.parking.place;

import ru.job4j.lsp.parking.interfaces.SizeOfPlaceIntarface;

/**
 * Class PlaceForTruck
 *
 * @author Petr B.
 * @since 05.12.2019, 13:07
 */
public class PlaceForTruck implements SizeOfPlaceIntarface {
    private static final int ONE_TRUCK_PLACE = 10;

    @Override
    public int getSizeOfSquare() {
        return ONE_TRUCK_PLACE;
    }
}
