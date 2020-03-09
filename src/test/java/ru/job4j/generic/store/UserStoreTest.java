package ru.job4j.generic.store;

import org.junit.Test;
import ru.job4j.generic.model.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class UserStoreTest
 *
 * @author Petr B.
 * @since 06.10.2019, 14:49
 */
public class UserStoreTest {
    @Test
    public void whenAddUserToUserStorageAndCheck() {
        UserStore store = new UserStore(5);
        store.add(new User("11"));
        store.add(new User("22"));
        store.add(new User("33"));
        store.add(new User("44"));
        store.add(new User("55"));
        assertThat(store.findById("55").getId(), is("55"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenCallMethodAddMoreThanSizeArrayGetException() {
        UserStore store = new UserStore(5);
        store.add(new User("11"));
        store.add(new User("22"));
        store.add(new User("33"));
        store.add(new User("44"));
        store.add(new User("55"));
        store.add(new User("66"));
    }

    @Test
    public void whenReplaceOneUserToOther() {
        UserStore store = new UserStore(5);
        store.add(new User("11"));
        store.add(new User("22"));
        boolean result = store.replace("22", new User("55"));
        assertThat(store.findById("55").getId(), is("55"));
        assertThat(result, is(true));
    }

    @Test
    public void whenDeleteUserTrue() {
        UserStore store = new UserStore(5);
        store.add(new User("11"));
        store.add(new User("22"));
        boolean result = store.delete("22");
        assertThat(result, is(true));
        assertThat(store.findById("11").getId(), is("11"));
    }
}