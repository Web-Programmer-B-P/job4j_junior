package ru.job4j.dip.storages;

import ru.job4j.dip.interfaces.BaseProductInterface;
import ru.job4j.dip.interfaces.BaseStorageIntarface;
import java.util.ArrayList;

/**
 * Class Trash
 *
 * @author Petr B.
 * @since 02.12.2019, 15:12
 */
public class Trash implements BaseStorageIntarface {
    private ArrayList<BaseProductInterface> currentProductList;

    public int getSize() {
        return currentProductList.size();
    }

    @Override
    public ArrayList<BaseProductInterface> getListOfProducts() {
        return currentProductList;
    }

    @Override
    public void setProductsList(ArrayList<BaseProductInterface> list) {
        currentProductList = list;
    }

    @Override
    public String getInfoOfSaveProducts() {
        int size = 0;
        if (currentProductList != null) {
            size = currentProductList.size();
        }
        return String.format("Name of Storage <%s> and size - [%s]", this.getClass().getSimpleName(), size);
    }
}
