package ru.job4j.generic.model;

import ru.job4j.generic.SimpleArray;
import ru.job4j.generic.interfaces.Store;

import java.util.Iterator;

/**
 * Class AbstractStore
 *
 * @author Petr B.
 * @since 06.10.2019, 18:27
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    private final int size;
    private SimpleArray<T> store;
    private int counter = 0;

    public AbstractStore(int size) {
        this.store = new SimpleArray<T>(size);
        this.size = size;
    }

    @Override
    public void add(T model) {
        Iterator<T> check = this.store.iterator();
        boolean flag = false;
        if (this.counter == size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        while (check.hasNext()) {
            T compare = check.next();
            if (compare != null && compare.getId().equals(model.getId())) {
                flag = true;
            }
        }
        if (!flag) {
            this.store.add(model);
            this.counter++;
        }
    }

    @Override
    public boolean replace(String id, T model) {
        boolean flag = false;
        int index = this.findByIndex(id);
        if (index != -1) {
            this.store.set(index, model);
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean delete(String id) {
        boolean flag = false;
        int index = this.findByIndex(id);
        if (index != -1) {
            this.store.remove(index);
            flag = true;
        }
        return flag;
    }

    @Override
    public  T findById(String id) {
        T result = null;
        int index = this.findByIndex(id);
        if (index != -1) {
            result = this.store.get(index);
        }
        return result;
    }

    private int findByIndex(String id) {
        int index = -1;
        int count = 0;
        for (T el : store) {
            if (el.getId().equals(id)) {
                index = count;
                break;
            }
            count++;
        }
        return index;
    }
}
