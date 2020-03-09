package ru.job4j.tree.interfaces;

import ru.job4j.tree.Node;

import java.util.Optional;

/**
 * Class SimpleTree
 *
 * @author Petr B.
 * @since 16.10.2019, 11:46
 */
public interface SimpleTree<E extends Comparable<E>> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return
     */
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}
