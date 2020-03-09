package ru.job4j.lsp.parking.place;

import ru.job4j.lsp.parking.interfaces.SizeOfPlaceIntarface;

/**
 * Class PlaceForCar
 *
 * @author Petr B.
 * @since 05.12.2019, 13:07
 */
public class PlaceForCar implements SizeOfPlaceIntarface {
    private static final int ONE_CAR_PLACE = 5;

    @Override
    public int getSizeOfSquare() {
        return ONE_CAR_PLACE;
    }
}
