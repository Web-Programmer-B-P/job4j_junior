package ru.job4j.statistic;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.statistic.Analize.User;

/**
 * Class AnalizeTest
 *
 * @author Petr B.
 * @since 19.10.2019, 9:36
 */
public class AnalizeTest {
    private List<User> before;
    private List<User> after;
    private Analize mainAnalizeMethod;

    @Before
    public void setUp() throws Exception {
        Analize.User first = new Analize.User(1, "Vasay");
        Analize.User second = new Analize.User(2, "Igor");
        Analize.User third = new Analize.User(3, "Mike");
        Analize.User fourth = new Analize.User(4, "Irina");
        Analize.User fifth = new Analize.User(5, "Nina");
        before = new ArrayList<>(Arrays.asList(first, second, third, fourth, fifth));
        after = new ArrayList<>(Arrays.asList(first, second, third, fourth, fifth));
    }


    @Test
    public void whenDeleteElementsFromList() {
       mainAnalizeMethod = new Analize();
       after.remove(0);
       after.remove(1);
       assertThat(
               mainAnalizeMethod.diff(before, after).toString(),
               is("Info{added=0, changed=0, deleted=2}")
       );
    }

    @Test
    public void whenChangeUserName() {
        mainAnalizeMethod = new Analize();
        after.set(0, new Analize.User(1, "Egorka"));
        assertThat(
                mainAnalizeMethod.diff(before, after).toString(),
                is("Info{added=0, changed=1, deleted=0}")
        );
    }

    @Test
    public void whenDoAllOperationsForList() {
        mainAnalizeMethod = new Analize();
        after.remove(0);
        after.remove(1);
        after.remove(2);
        after.add(new User(10, "car"));
        after.add(new User(11, "bus"));
        after.add(new User(15, "cycle"));
        after.add(new User(19, "motorbike"));
        after.set(0, new User(2, "Change name for this user"));
        assertThat(
                mainAnalizeMethod.diff(before, after).toString(),
                is("Info{added=4, changed=1, deleted=3}")
        );
    }
}