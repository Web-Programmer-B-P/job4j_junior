package ru.job4j.dip.distribution;

import ru.job4j.dip.interfaces.BaseProductInterface;
import ru.job4j.dip.interfaces.BaseStorageIntarface;
import ru.job4j.dip.storages.Shop;
import ru.job4j.dip.storages.Trash;
import ru.job4j.dip.storages.WareHouse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class ControllQuality
 *
 * @author Petr B.
 * @since 02.12.2019, 15:22
 */
public class ControllQuality {
    private static final int WARE_HOUSE = 2;
    private static final int SHOP = 1;
    private static final int SHOP_DISSCOUNT = 0;
    private static final int TRASH = -1;
    private ArrayList<BaseProductInterface> distributionList;
    private Map<String, String> infoForEachStorage = new HashMap<>();
    private ArrayList<BaseProductInterface> shopList = new ArrayList<>();
    private ArrayList<BaseProductInterface> shopDiscountList = new ArrayList<>();
    private ArrayList<BaseProductInterface> wareHouseList = new ArrayList<>();
    private ArrayList<BaseProductInterface> trashList = new ArrayList<>();
    private Map<String, BaseStorageIntarface> listOfStorages;
    private BaseStorageIntarface target;

    public ControllQuality(ArrayList<BaseProductInterface> products) {
        distributionList = products;
        fillMapOfStorage();
    }

    public ControllQuality(ArrayList<BaseProductInterface> products, BaseStorageIntarface targetToStore) {
        distributionList = products;
        target = targetToStore;
        fillMapOfStorage();
    }

    public void distributionProduct() {
        if (target != null) {
            String key = target.getClass().getSimpleName();
            if (listOfStorages.containsKey(key)) {
                listOfStorages.get(key).setProductsList(distributionList);
                fillMapOfInformation();
            }
        } else {
            for (BaseProductInterface currentProduct : distributionList) {
                switch (currentProduct.getProcentUsageOfProduct()) {
                    case WARE_HOUSE:
                        wareHouseList.add(currentProduct);
                        break;
                    case SHOP:
                        shopList.add(currentProduct);
                        break;
                    case SHOP_DISSCOUNT:
                        shopDiscountList.add(currentProduct);
                        break;
                    case TRASH:
                        trashList.add(currentProduct);
                        break;
                    default:
                        System.out.println("Такого хранилища нет!");
                        break;
                }
            }
            saveAllProducts();
        }
    }

    private void saveAllProducts() {
        shopList.addAll(shopDiscountList);
        listOfStorages.get("Shop").setProductsList(shopList);
        listOfStorages.get("Trash").setProductsList(trashList);
        listOfStorages.get("WareHouse").setProductsList(wareHouseList);
        fillMapOfInformation();
    }

    private void fillMapOfInformation() {
        infoForEachStorage.put("WareHouse", listOfStorages.get("WareHouse").getInfoOfSaveProducts());
        infoForEachStorage.put("Shop", listOfStorages.get("Shop").getInfoOfSaveProducts());
        infoForEachStorage.put("Trash", listOfStorages.get("Trash").getInfoOfSaveProducts());
    }

    public Map getInfo() {
        return infoForEachStorage;
    }

    private void fillMapOfStorage() {
        listOfStorages = new HashMap<>();
        listOfStorages.put("Shop", new Shop());
        listOfStorages.put("Trash", new Trash());
        listOfStorages.put("WareHouse", new WareHouse());
    }

    public void resort() {
        target = null;
        distributionList = new ArrayList<>();
        if (listOfStorages.get("WareHouse").getListOfProducts() != null) {
            distributionList.addAll(listOfStorages.get("WareHouse").getListOfProducts());
        }
        if (listOfStorages.get("Shop").getListOfProducts() != null) {
            distributionList.addAll(listOfStorages.get("Shop").getListOfProducts());
        }
        if (listOfStorages.get("Trash").getListOfProducts() != null) {
            distributionList.addAll(listOfStorages.get("Trash").getListOfProducts());
        }
        distributionProduct();
    }
}
