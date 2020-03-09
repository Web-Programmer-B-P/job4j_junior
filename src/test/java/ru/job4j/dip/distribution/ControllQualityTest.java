package ru.job4j.dip.distribution;

import org.junit.Test;
import ru.job4j.dip.interfaces.BaseProductInterface;
import ru.job4j.dip.products.Food;
import ru.job4j.dip.storages.WareHouse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ControllQualityTest
 *
 * @author Petr B.
 * @since 07.12.2019, 11:27
 */
public class ControllQualityTest {
    @Test
    public void whenAddProductsWithTargetAfterThatCallResortAndProductsChangedStorage() {
        LocalDate create = LocalDate.of(2019, 11, 30);
        LocalDate expaire = LocalDate.of(2019, 12, 2);
        Food hotDog = new Food("Hot-Dog", create, expaire, 200);
        Food shaurma = new Food("Shaurma", create, expaire, 150);
        ArrayList<BaseProductInterface> list = new ArrayList<>(Arrays.asList(hotDog, shaurma));
        ControllQuality controll = new ControllQuality(list, new WareHouse());
        controll.distributionProduct();
        assertThat(controll.getInfo().get("WareHouse"), is("Name of Storage <WareHouse> and size - [2]"));
        controll.resort();
        assertThat(controll.getInfo().get("Trash"), is("Name of Storage <Trash> and size - [2]"));
    }

    @Test
    public void whenAddTrashProduct() {
        LocalDate create = LocalDate.of(2019, 11, 30);
        LocalDate expaire = LocalDate.of(2019, 12, 2);
        Food hotDog = new Food("Sandwich", create, expaire, 200);
        Food shaurma = new Food("Varenik", create, expaire, 150);
        ArrayList<BaseProductInterface> list = new ArrayList<>(Arrays.asList(hotDog, shaurma));
        ControllQuality controll = new ControllQuality(list);
        controll.distributionProduct();
        assertThat(controll.getInfo().get("Trash"), is("Name of Storage <Trash> and size - [2]"));
    }
}