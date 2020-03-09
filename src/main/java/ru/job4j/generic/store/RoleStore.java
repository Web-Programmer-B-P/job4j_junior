package ru.job4j.generic.store;

import ru.job4j.generic.model.AbstractStore;
import ru.job4j.generic.model.Role;

/**
 * Class RoleStore
 *
 * @author Petr B.
 * @since 06.10.2019, 13:54
 */
public class RoleStore extends AbstractStore<Role> {
    public RoleStore(int size) {
        super(size);
    }
}
