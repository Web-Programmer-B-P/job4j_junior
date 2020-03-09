package ru.job4j.map.model;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class UserTest
 *
 * @author Petr B.
 * @since 13.10.2019, 8:35
 */
public class UserTest {
    private long date = 13112019;

    @Test
    public void whenCreateTwoObjectUserAndPutToMap() {
        Map<User, Object> storage = new HashMap<>();
        storage.put(new User("Alibaba", 40, date), new User("Neo", 1, date));
        storage.put(new User("Alibaba", 40, date), new User("Neo", 1, date));
        String expected = "{User{name='Alibaba', children=40, birthday=13112019}=User{name='Neo', children=1, birthday=13112019}}";
        assertThat(storage.toString(), is(expected));
    }
}