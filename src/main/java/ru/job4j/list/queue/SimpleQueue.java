package ru.job4j.list.queue;

import ru.job4j.list.stack.SimpleStack;

/**
 * Class SimpleQueue
 *
 * @author Petr B.
 * @since 11.10.2019, 18:11
 */
public class SimpleQueue<T> {
    private SimpleStack<T> stackFirst = new SimpleStack<>();
    private SimpleStack<T> stackSecond;

    public T poll() {
        final int size = stackFirst.getSize();
        if (stackSecond.getSize() == 0) {
            for (int index = 0; index < size; index++) {
                stackSecond.push(stackFirst.poll());
            }
        }
        return stackSecond.poll();
    }

    public void push(T value) {
        stackSecond = new SimpleStack<>();
        stackFirst.push(value);
    }
}
