package ru.job4j.demo;

/**
 * Class OutOfMemory
 *
 * @author Petr B.
 * @since 15.12.2019, 18:05
 */
public class OutOfMemory {
    private String name;

    public OutOfMemory(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {
        //устанавливаем память в -Xmx6m и нам хватит цикла ниже чтобы положить приложение
        for (int i = 0; i < 100000; i++) {
            OutOfMemory outOfMemory = new OutOfMemory("outOfMemeoryError");
            outOfMemory = null;
        }
    }
}