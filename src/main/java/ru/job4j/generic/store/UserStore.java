package ru.job4j.generic.store;

import ru.job4j.generic.model.AbstractStore;
import ru.job4j.generic.model.User;

/**
 * Class UserStore
 *
 * @author Petr B.
 * @since 06.10.2019, 13:54
 */
public class UserStore extends AbstractStore<User> {
    public UserStore(int size) {
        super(size);
    }
}
