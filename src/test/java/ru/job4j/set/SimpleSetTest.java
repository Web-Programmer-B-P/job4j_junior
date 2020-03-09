package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleSetTest
 *
 * @author Petr B.
 * @since 12.10.2019, 15:22
 */
public class SimpleSetTest {
    @Test
    public void whenAddFalse() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        assertThat(set.add(1), is(false));
    }

    @Test
    public void whenTestIterator() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        Iterator<Integer> it = set.iterator();
        it.next();
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(false));
    }
}