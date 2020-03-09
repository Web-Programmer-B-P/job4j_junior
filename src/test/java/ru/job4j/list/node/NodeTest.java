package ru.job4j.list.node;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.list.node.cycle.FindCycle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class NodeTest
 *
 * @author Petr B.
 * @since 11.10.2019, 22:13
 */
public class NodeTest {
    private FindCycle check;

    @Before
    public void setUp() {
        check = new FindCycle();
    }

    @Test
    public void whenHasCycleTrue() {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        assertThat(check.hasCycle(first), is(true));
    }

    @Test
    public void whenHasCycleFalse() {
        Node first = new Node(1);
        Node second = new Node(2);

        first.next = second;
        second.next = null;
        assertThat(check.hasCycle(second), is(false));
    }

}