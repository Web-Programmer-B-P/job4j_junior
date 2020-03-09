package ru.job4j.isp.actions;

import ru.job4j.isp.interfaces.DoAction;
import ru.job4j.isp.model.Menu;
import ru.job4j.isp.view.ShowMenu;
import java.util.Map;

/**
 * Class MenuAction
 *
 * @author Petr B.
 * @since 06.12.2019, 16:36
 */
public class MenuAction implements DoAction {
    private final ShowMenu menu;
    private final Map<String, Menu> list;

    public MenuAction(final ShowMenu menu) {
        this.menu = menu;
        list = menu.getListOfMenuForAction();
    }

    @Override
    public boolean action(String elementOfMenu) {
        return list.containsKey(elementOfMenu);
    }
}
