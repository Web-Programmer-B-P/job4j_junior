package ru.job4j.lsp.storages;

import ru.job4j.lsp.interfaces.BaseProductInterface;
import ru.job4j.lsp.interfaces.BaseStorageIntarface;
import java.util.ArrayList;

/**
 * Class Shop
 *
 * @author Petr B.
 * @since 02.12.2019, 15:12
 */
public class Shop implements BaseStorageIntarface {
    private final ArrayList<BaseProductInterface> currentProductList;

    public Shop(ArrayList<BaseProductInterface> products) {
        currentProductList = products;
    }

    public int getSize() {
        return currentProductList.size();
    }

    public ArrayList<BaseProductInterface> getListOfProducts() {
        return currentProductList;
    }
}
