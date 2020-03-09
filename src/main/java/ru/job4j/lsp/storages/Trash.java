package ru.job4j.lsp.storages;

import ru.job4j.lsp.interfaces.BaseProductInterface;
import ru.job4j.lsp.interfaces.BaseStorageIntarface;
import java.util.ArrayList;

/**
 * Class Trash
 *
 * @author Petr B.
 * @since 02.12.2019, 15:12
 */
public class Trash implements BaseStorageIntarface {
    private final ArrayList<BaseProductInterface> currentProductList;

    public Trash(ArrayList<BaseProductInterface> products) {
        currentProductList = products;
    }

    public int getSize() {
        return currentProductList.size();
    }

    public ArrayList<BaseProductInterface> getListOfProducts() {
        return currentProductList;
    }
}
