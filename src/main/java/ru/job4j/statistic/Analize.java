package ru.job4j.statistic;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class Analize
 *
 * @author Petr B.
 * @since 19.10.2019, 9:30
 */
public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info result = new Info();
        Map<Integer, User> mapPrev = previous.stream().collect(Collectors.toMap(User::getId, user -> user));
        Map<Integer, User> mapCurr = current.stream().collect(Collectors.toMap(User::getId, user -> user));
        int del = 0;
        for (Map.Entry<Integer, User> nex : mapCurr.entrySet()) {
            if (!mapPrev.containsKey(nex.getKey())) {
                result.added++;
            }
            if (mapPrev.containsKey(nex.getKey())) {
                del++;
                String check = mapPrev.get(nex.getKey()).name;
                if (!check.equals(nex.getValue().name)) {
                    result.changed++;
                }
            }
        }
        result.deleted = mapPrev.size() - del;
        return result;
    }

    public static class User {
        int id;
        String name;

        public User(int identity, String userName) {
            id = identity;
            name = userName;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        @Override
        public String toString() {
            return "Info{"
                    + "added=" + added
                    + ", changed=" + changed
                    + ", deleted=" + deleted
                    + '}';
        }
    }
}
