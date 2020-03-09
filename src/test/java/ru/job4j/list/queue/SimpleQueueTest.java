package ru.job4j.list.queue;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleQueueTest
 *
 * @author Petr B.
 * @since 11.10.2019, 18:12
 */
public class SimpleQueueTest {
    private SimpleQueue<Integer> queue = new SimpleQueue<>();

    @Before
    public void setUp() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
    }

    @Test
    public void whenPoll() {
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
        queue.push(4);
        assertThat(queue.poll(), is(4));
    }
}