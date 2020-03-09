package ru.job4j.demo;

/**
 * Class StackOverFlowError
 *
 * @author Petr B.
 * @since 15.12.2019, 18:18
 */
public class StackOverFlowError {
    public static int index;

    public void stackOver() {
        index++;
        stackOver();
    }

    public static void main(String[] args) {
        try {
            new StackOverFlowError().stackOver();
        } catch (StackOverflowError stackOverflowError) {
            System.out.println("stackOverflowError");
        }
    }
}
