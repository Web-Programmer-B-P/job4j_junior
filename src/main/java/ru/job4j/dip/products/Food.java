package ru.job4j.dip.products;

import ru.job4j.dip.interfaces.BaseProductInterface;

import java.time.LocalDate;
import java.time.Period;

/**
 * Class Food
 *
 * @author Petr B.
 * @since 02.12.2019, 12:30
 */
public class Food implements BaseProductInterface {
    private String nameProduct;
    private LocalDate createdDateProduct;
    private LocalDate expairedDateProduct;
    private double priceProduct;
    private int disscountProduct;

    public Food(String name, LocalDate createdDate, LocalDate expairedDate, double price) {
        nameProduct = name;
        createdDateProduct = createdDate;
        expairedDateProduct = expairedDate;
        priceProduct = price;
    }

    public LocalDate getCreatedDateProduct() {
        return createdDateProduct;
    }

    public LocalDate getExpairedDateProduct() {
        return expairedDateProduct;
    }

    public int getDisscountProduct() {
        return disscountProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    /**
     * Метод высчитывает процентаж срока годности продукта.
     *
     * @return int
     *  2 - срок годности израсходован меньше чем на 25%,
     *  1 - срок годности в промежутке между 75% - 25%,
     *  0 - срок годности меньше 25% и больше 1%,
     * -1 - 0% и меньше.
     */
    @Override
    public int getProcentUsageOfProduct() {
        int res = -1;
        Period basePeriod = Period.between(createdDateProduct, expairedDateProduct);
        Period currentPeriod = Period.between(LocalDate.now(), expairedDateProduct);
        double baseDate = ((double) basePeriod.getYears() * 365) + ((double) basePeriod.getMonths() * 31) + (double) basePeriod.getDays();
        double currentDate = ((double) currentPeriod.getYears() * 365) + ((double) currentPeriod.getMonths() * 31) + (double) currentPeriod.getDays();
        double current = ((baseDate - currentDate) / baseDate) * 100;
        if (current < 25) {
            res = 2;
        }
        if (current >= 25 && current < 75) {
            res = 1;
        }
        if (current > 75 && current < 100) {
            disscountProduct = 50;
            res = 0;
        }
        return res;
    }
}
