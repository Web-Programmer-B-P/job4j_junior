package ru.job4j.list.node;


/**
 * Class Node
 *
 * @author Petr B.
 * @since 11.10.2019, 19:20
 */
public class Node<T> {
    public T value;
    public Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}
