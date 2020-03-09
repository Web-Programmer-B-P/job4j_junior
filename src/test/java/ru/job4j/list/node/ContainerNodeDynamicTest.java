package ru.job4j.list.node;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ContainerNodeDynamicTest
 *
 * @author Petr B.
 * @since 10.10.2019, 18:35
 */
public class ContainerNodeDynamicTest {
    private ContainerNodeDynamic<Integer> store;
    private Iterator<Integer> iter;

    @Before
    public void setUp() {
        store = new ContainerNodeDynamic<>();
        store.add(1);
        store.add(2);
        store.add(3);
    }

    @Test
    public void whenFindElement() {
        assertThat(store.get(0), is(3));
    }

    @Test
    public void whenNext() {
        iter = store.iterator();
        iter.next();
        iter.next();
        assertThat(iter.next(), is(1));
    }

    @Test
    public void whenHasNext() {
        iter = store.iterator();
        iter.next();
        iter.next();
        assertThat(iter.hasNext(), is(true));
        iter.next();
        assertThat(iter.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenGetException() {
        iter = store.iterator();
        iter.next();
        iter.next();
        store.add(4);
        iter.next();
    }
}