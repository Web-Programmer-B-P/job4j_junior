package ru.job4j.srp.input;

import ru.job4j.srp.interfaces.CommonInputData;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class FakeInputData
 *
 * @author Petr B.
 * @since 01.12.2019, 11:52
 */
public class FakeInputData implements CommonInputData {
    private final ArrayList<String> list;
    private final Iterator<String> itr;

    public FakeInputData(ArrayList<String> fakeDataList) {
        list = fakeDataList;
        itr = list.iterator();
    }

    @Override
    public String getAnwser(String anwser) {
        String operation = itr.next();
        System.out.println(anwser + " " + operation);
        return operation;
    }
}
