package ru.job4j.iterators.doublearray;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class JaggedArrayIteratorTest
 *
 * @author Petr B.
 * @since 02.10.2019, 10:38
 */

/**
 * Class JaggedArrayIteratorTest
 *
 * @author Petr B.
 * @since 01.10.2019, 10:26
 */
public class JaggedArrayIteratorTest {

    private JaggedArrayIterator it;

    @Before
    public void setUp() {
        it = new JaggedArrayIterator(new int[][]{{1}, {3, 4}, {7, 8, 9}, {12, 13}});
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
        assertThat(it.next(), is(12));
        assertThat(it.next(), is(13));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
        assertThat(it.next(), is(12));
        assertThat(it.next(), is(13));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(12));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(13));
        assertThat(it.hasNext(), is(false));
    }
}