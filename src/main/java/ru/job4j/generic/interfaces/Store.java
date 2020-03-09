package ru.job4j.generic.interfaces;

import ru.job4j.generic.model.Base;

/**
 * Class Store
 *
 * @author Petr B.
 * @since 06.10.2019, 13:52
 */
public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
