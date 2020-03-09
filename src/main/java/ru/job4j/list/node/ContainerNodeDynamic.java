package ru.job4j.list.node;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ContainerListNodeDynamic
 *
 * @author Petr B.
 * @since 10.10.2019, 18:34
 */
public class ContainerNodeDynamic<E> implements Iterable<E> {
    private int size;
    private Node<E> first;
    private int modCount;

    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = first;
        first = newLink;
        size++;
        modCount++;
    }

    public E delete() {
        E oldValue = null;
        if (size > 0) {
            Node<E> newValue = first.next;
            first.next = null;
            oldValue = first.data;
            first = newValue;
            size--;
        }
        return oldValue;
    }

    public E get(int index) {
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public int getSize() {
        return size;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> checkNext = first;
            private int index;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (index < size) {
                    result = true;
                }
                return result;
            }

            @Override
            public E next() {
                checkNext = first;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                first = first.next;
                index++;
                return checkNext.data;
            }
        };
    }
}
