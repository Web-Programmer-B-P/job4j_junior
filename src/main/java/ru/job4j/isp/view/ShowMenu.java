package ru.job4j.isp.view;

import ru.job4j.isp.interfaces.DrawMenu;
import ru.job4j.isp.model.Menu;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class ShowMenu
 *
 * @author Petr B.
 * @since 06.12.2019, 14:45
 */
public class ShowMenu implements DrawMenu {
    private final Menu menu;
    private final Map<String, Menu> listOfMenuForView;
    private final Map<String, Menu> listOfMenuForAction;
    private int count;

    public ShowMenu(Menu menu) {
        this.menu = menu;
        listOfMenuForView = new LinkedHashMap<>();
        listOfMenuForAction = new HashMap<>();
        init();
    }

    private void init() {
        buildViewOfMenu(menu);
    }

    public Map<String, Menu> getListOfMenuForView() {
        return listOfMenuForView;
    }

    public Map<String, Menu> getListOfMenuForAction() {
        return listOfMenuForAction;
    }

    @Override
    public void showMenu() {
        for (Map.Entry<String, Menu> el : listOfMenuForView.entrySet()) {
            System.out.println(el.getKey());
        }
    }

    private Menu buildViewOfMenu(Menu el) {
        Menu res = null;
        if (count == 0) {
            listOfMenuForAction.put(el.getName(), el);
            listOfMenuForView.put(showName(count, el.getName()), el);
        }
        if (el.getListOfChildren() != null) {
            count++;
            for (Menu m : el.getListOfChildren()) {
                listOfMenuForView.put(showName(count, m.getName()), m);
                listOfMenuForAction.put(m.getName(), m);
                buildViewOfMenu(m);
            }
            count--;
        } else {
            return el;
        }
        return res;
    }

    @Override
    public String showName(int index, String name) {
        String symbol = "";
        String res = null;
        for (int i = 0; i < index; i++) {
            symbol += "--";
        }
        res = symbol.isEmpty() ? name : symbol + name;
        return res;
    }
}
