package ru.job4j.tree;

import ru.job4j.tree.interfaces.SimpleTree;

import java.util.*;

/**
 * Class Tree
 *
 * @author Petr B.
 * @since 16.10.2019, 16:11
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E>, Iterable<E> {
    private Node<E> root;

    public Tree(E r) {
        root = new Node<>(r);
    }

    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                boolean result = !data.isEmpty();
                return result;
            }

            @Override
            public E next() {
                Node<E> el = data.poll();
                if (el != null) {
                    data.addAll(el.leaves());
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return el.getValue();
            }
        };
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (findBy(parent).isPresent() && findBy(child).isEmpty()) {
            findBy(parent).get().add(new Node<E>(child));
            result = true;
        } else {
            root.add(new Node<E>(parent));
            findBy(parent).get().add(new Node<E>(child));
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    public boolean isBinary() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        boolean result = true;
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            for (Node<E> child : el.leaves()) {
                if (el.leaves().size() > 2) {
                    result = false;
                    break;
                }
                data.offer(child);
            }
        }
        return result;
    }
}
