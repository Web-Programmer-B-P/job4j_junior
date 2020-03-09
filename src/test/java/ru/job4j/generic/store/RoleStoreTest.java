package ru.job4j.generic.store;

import org.junit.Test;
import ru.job4j.generic.model.Role;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class RoleStoreTest
 *
 * @author Petr B.
 * @since 06.10.2019, 19:38
 */
public class RoleStoreTest {
    @Test
    public void whenAddUserToUserStorageAndCheck() {
        RoleStore store = new RoleStore(5);
        store.add(new Role("11"));
        store.add(new Role("22"));
        store.add(new Role("33"));
        store.add(new Role("44"));
        store.add(new Role("55"));
        assertThat(store.findById("55").getId(), is("55"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenCallMethodAddMoreThanSizeArrayGetException() {
        RoleStore store = new RoleStore(5);
        store.add(new Role("11"));
        store.add(new Role("22"));
        store.add(new Role("33"));
        store.add(new Role("44"));
        store.add(new Role("55"));
        store.add(new Role("66"));
    }

    @Test
    public void whenReplaceOneUserToOther() {
        RoleStore store = new RoleStore(5);
        store.add(new Role("11"));
        store.add(new Role("22"));
        boolean result = store.replace("22", new Role("55"));
        assertThat(store.findById("55").getId(), is("55"));
        assertThat(result, is(true));
    }

    @Test
    public void whenDeleteUserTrue() {
        RoleStore store = new RoleStore(5);
        store.add(new Role("11"));
        store.add(new Role("22"));
        boolean result = store.delete("22");
        assertThat(result, is(true));
        assertThat(store.findById("11").getId(), is("11"));
    }

}