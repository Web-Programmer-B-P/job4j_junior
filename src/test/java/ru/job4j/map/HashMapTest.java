package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Class HashMapTest
 *
 * @author Petr B.
 * @since 15.10.2019, 10:52
 */
public class HashMapTest {
    @Test
    public void whenAddElementToMap() {
        HashMap<Integer, String> map = new HashMap<>();
        map.insert(3, "Hello");
        map.insert(1, "Hi");
        map.insert(150, "Hundred fifty");
        map.insert(4, "four");
        map.insert(2, "second");
        map.insert(6, "six");
        map.insert(8, "eight");
        map.insert(10, "ten");
        map.insert(7, "tank");
        map.insert(50, "fffff");
        map.insert(74, "SF");
        map.insert(99, "NN");
        map.insert(9, "N");
        map.insert(68, "NN");
        map.insert(33, "NN");
        boolean result = map.insert(68, "Seven");
        assertThat(result, is(false));
    }

    @Test
    public void whenGetValueByKey() {
        HashMap<Integer, String> map = new HashMap<>();
        map.insert(3, "Hello");
        map.insert(1, "Hi");
        map.insert(150, "Hundred fifty");
        map.insert(4, "four");
        assertThat(map.get(1), is("Hi"));
    }

    @Test
    public void whenDeleteElementTrue() {
        HashMap<Integer, String> map = new HashMap<>();
        map.insert(3, "Hello");
        map.insert(1, "Hi");
        map.insert(150, "Hundred fifty");
        map.insert(4, "four");
        assertThat(map.delete(1), is(true));
        assertThat(map.get(1), is(nullValue()));
    }

    @Test
    public void whenHasNextFalse() {
        HashMap<Integer, String> map = new HashMap<>();
        map.insert(0, "Hello");
        map.insert(1, "Hi");
        map.insert(150, "Hundred fifty");
        map.insert(4, "four");
        Iterator<String> it = map.iterator();
        it.next();
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(true));
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));

    }

    @Test
    public void whenCheckSizeBeforeAndAfter() {
        HashMap<Integer, String> map = new HashMap<>();
        map.insert(0, "Hello");
        map.insert(1, "Hi");
        map.insert(150, "Hundred fifty");
        map.insert(4, "four");
        assertThat(map.getNumberOfElements(), is(4));
        map.delete(150);
        assertThat(map.getNumberOfElements(), is(3));
    }
}