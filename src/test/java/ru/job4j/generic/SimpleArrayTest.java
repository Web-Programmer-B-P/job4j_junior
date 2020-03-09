package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleArrayTest
 *
 * @author Petr B.
 * @since 05.10.2019, 16:40
 */
public class SimpleArrayTest {

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddElementToSimpleArray() {
        SimpleArray<String> data = new SimpleArray<String>(2);
        data.add("First");
        data.add("Second");
        data.add("Exception");
    }

    @Test
    public void whenGetElementByIndex() {
        SimpleArray<String> data = new SimpleArray<String>(2);
        data.add("First");
        data.add("Second");
        assertThat(data.get(1), is("Second"));
    }

    @Test
    public void whenPutElementInArrayByIndex() {
        SimpleArray<String> data = new SimpleArray<String>(2);
        data.add("First");
        data.add("Second");
        data.set(0, "Zero");
        assertThat(data.get(0), is("Zero"));
    }

    @Test
    public void whenCheckNullItMustBeAtTheAnd() {
        SimpleArray<String> data = new SimpleArray<String>(4);
        data.add("First");
        data.add("Second");
        data.add("Third");
        data.add("Fourth");
        data.remove(2);
        assertThat(data.get(3), is(nullValue()));
    }

    @Test
    public void whenDeleteElemenAndMoveAllElemetsToOneStap() {
        SimpleArray<String> data = new SimpleArray<String>(4);
        data.add("First");
        data.add("Second");
        data.add("Third");
        data.add("Fourth");
        data.remove(2);
        assertThat(data.get(2), is("Fourth"));
    }

    @Test
    public void whenUseIterator() {
        SimpleArray<String> data = new SimpleArray<String>(4);
        data.add("First");
        data.add("Second");
        data.add("Third");
        data.add("Fourth");
        Iterator<String> result = data.iterator();
        result.next();
        result.next();
        result.next();
        assertThat(result.next(), is("Fourth"));
    }

    @Test
    public void whenCheckMethodHasNext() {
        SimpleArray<String> data = new SimpleArray<String>(4);
        data.add("First");
        data.add("Second");
        data.add("Third");
        data.add("Fourth");
        Iterator<String> result = data.iterator();
        result.next();
        result.next();
        result.next();
        result.next();
        assertThat(result.hasNext(), is(false));
    }
}