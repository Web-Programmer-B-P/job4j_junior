package ru.job4j.list.node.cycle;

import ru.job4j.list.node.Node;

/**
 * Class FindCycle
 *
 * @author Petr B.
 * @since 12.10.2019, 7:57
 */
public class FindCycle {
    /**
     * Метод принимает объект Node и size размер
     *
     * @param value object Node
     * @return true/false
     */
    public boolean hasCycle(Node value) {
        boolean result = false;
        Node fast = value;
        Node slow = fast;
        while (true) {
            slow = slow.next;
            if (slow == null || fast.next.next == null) {
                break;
            }
            fast = fast.next.next;
            if (slow == fast) {
                result = true;
                break;
            }
        }
        return result;
    }
}