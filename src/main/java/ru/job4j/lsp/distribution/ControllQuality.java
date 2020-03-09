package ru.job4j.lsp.distribution;

import ru.job4j.lsp.interfaces.BaseProductInterface;
import ru.job4j.lsp.storages.Shop;
import ru.job4j.lsp.storages.Trash;
import ru.job4j.lsp.storages.WareHouse;

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
    private final ArrayList<BaseProductInterface> listOfProductsForDistribution;
    private Map<String, Integer> nameAndSizeForWichStorage = new HashMap<>();
    private ArrayList<BaseProductInterface> listOfProductsForShop = new ArrayList<>();
    private ArrayList<BaseProductInterface> listOfProductsForShopWithDisscount = new ArrayList<>();
    private ArrayList<BaseProductInterface> listOfProductsForWareHouse = new ArrayList<>();
    private ArrayList<BaseProductInterface> listOfProductsForTrash = new ArrayList<>();

    public ControllQuality(ArrayList<BaseProductInterface> products) {
        listOfProductsForDistribution = products;
    }

    public void distributionProduct() {
        for (BaseProductInterface currentProduct : listOfProductsForDistribution) {
            switch (currentProduct.getProcentUsageOfProduct()) {
                case WARE_HOUSE:
                    listOfProductsForWareHouse.add(currentProduct);
                    break;
                case SHOP:
                    listOfProductsForShop.add(currentProduct);
                    break;
                case SHOP_DISSCOUNT:
                    listOfProductsForShopWithDisscount.add(currentProduct);
                    break;
                case TRASH:
                    listOfProductsForTrash.add(currentProduct);
                    break;
                default:
                    System.out.println("Такого хранилища нет!");
                    break;
            }
        }
        saveAllProductListInTheirPlaces();
    }

    private void saveAllProductListInTheirPlaces() {
        new WareHouse(listOfProductsForWareHouse);
        new Shop(listOfProductsForShop);
        new Shop(listOfProductsForShopWithDisscount);
        new Trash(listOfProductsForTrash);
        fillMapOfInformation();
    }

    private void fillMapOfInformation() {
        nameAndSizeForWichStorage.put("WareHouse", listOfProductsForWareHouse.size());
        nameAndSizeForWichStorage.put("Shop", listOfProductsForShop.size());
        nameAndSizeForWichStorage.put("ShopDisscount", listOfProductsForShopWithDisscount.size());
        nameAndSizeForWichStorage.put("Trash", listOfProductsForTrash.size());
    }

    public Map getList() {
        return nameAndSizeForWichStorage;
    }
}
