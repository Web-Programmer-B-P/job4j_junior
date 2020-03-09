package ru.job4j.list.stack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleStackTest
 *
 * @author Petr B.
 * @since 11.10.2019, 11:01
 */
public class SimpleStackTest {
    private SimpleStack<Integer> stack;

    @Before
    public void beforeTest() {
        stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void whenPoll() {
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }

    @Test
    public void whenPushWhithPoll() {
        stack.push(5);
        assertThat(stack.poll(), is(5));
        assertThat(stack.poll(), is(3));
    }
}