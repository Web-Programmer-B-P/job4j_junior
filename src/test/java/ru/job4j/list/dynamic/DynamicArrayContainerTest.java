package ru.job4j.list.dynamic;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class DynamicArrayContainerTest
 *
 * @author Petr B.
 * @since 09.10.2019, 11:17
 */
public class DynamicArrayContainerTest {
    private DynamicArrayContainer<Integer> input;
    private Iterator<Integer> it;

    @Before
    public void setUp() {
        input = new DynamicArrayContainer<Integer>();
        input.add(1);
        input.add(2);
        input.add(3);
    }

    @Test
    public void whenAddElementInContainer() {
        assertThat(input.get(2), is(3));
    }

    @Test
    public void whenCheckNextAndHasNextMethods() {
        it = input.iterator();
        it.next();
        it.next();
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCheckWorkIteratorAndThrowException() {
        it = input.iterator();
        it.next();
        it.next();
        assertThat(it.next(), is(3));
        input.add(4);
        it.next();
    }

    @Test
    public void whenCreateContainerWhithStartSize() {
        DynamicArrayContainer<Integer> dynamic = new DynamicArrayContainer<Integer>(100);
        assertThat(dynamic.getSize(), is(100));
    }
}