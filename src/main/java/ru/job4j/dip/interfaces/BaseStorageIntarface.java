package ru.job4j.dip.interfaces;

import java.util.ArrayList;

/**
 * Class BaseStorageIntarface
 *
 * @author Petr B.
 * @since 02.12.2019, 12:26
 */
public interface BaseStorageIntarface {
    void setProductsList(ArrayList<BaseProductInterface> list);
    String getInfoOfSaveProducts();
    ArrayList<BaseProductInterface> getListOfProducts();
}
