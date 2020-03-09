package ru.job4j.demo;

/**
 * Class User
 *
 * @author Petr B.
 * @since 11.12.2019, 12:33
 */
public class User {
    private String name;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Call finalize method");
    }

    public static void main(String[] args) {
        info("До выполнения");
        for (int i = 0; i < 1000; i++) {
            User user = new User("name");
            user = null;
        }
        info("После выполнения");
    }

    public static void info(String string) {
        System.out.println(string);
        int mb = 1024;
        Runtime runtime = Runtime.getRuntime();
        long mem1 = runtime.freeMemory();
        long total = runtime.totalMemory();
        System.out.println("Размеры в байтах");
        System.out.println(mem1);
        System.out.println(total);
        System.out.println((total) - (mem1));
        System.out.println();
        System.out.println("Размеры в мегабайтах");
        System.out.println(mem1 / 1024);
        System.out.println(total / 1024);
        System.out.println((total / mb) - (mem1 / mb));
    }
}
