package ru.job4j.tdd;

import ru.job4j.tdd.exception.WrongException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class SimpleGenerator
 *
 * @author Petr B.
 * @since 08.12.2019, 14:03
 */
public class SimpleGenerator {
    private final Pattern keys;

    public SimpleGenerator(Pattern regex) {
        keys = regex;
    }

    public String generate(String patternTemplate, Map<String, String> listWithValuesForTemplate) {
        Set<String> groups = findGroupsByRegex(patternTemplate);
        Map<String, String> groupNameAndCleanNameList = fillMapWithNameAndGroup(groups);
        return generateFinalString(listWithValuesForTemplate, groupNameAndCleanNameList, patternTemplate);
    }

    private Set<String> findGroupsByRegex(String stringPattern) {
        Set<String> res = new HashSet<>();
        Matcher matcher = keys.matcher(stringPattern);
        while (matcher.find()) {
            res.add(matcher.group());
        }
        return res;
    }

    private Map<String, String> fillMapWithNameAndGroup(Set<String> groups) {
        Map<String, String> map = new HashMap<>();
        for (String el : groups) {
            map.put(el.substring(2, el.length() - 1), el);
        }
        return map;
    }

    private String generateFinalString(Map<String, String> inputMap, Map<String, String> madeMap, String inputString) {
        if (madeMap.size() == inputMap.size()) {
            for (Map.Entry<String, String> find : madeMap.entrySet()) {
                if (inputMap.containsKey(find.getKey())) {
                    String target = find.getValue();
                    String value = inputMap.get(find.getKey());
                    inputString = inputString.replace(target, value);
                } else {
                    throw new WrongException("The map doesn`t have key like " + find.getKey() + "!");
                }
            }
        } else {
            throw new WrongException("The size in your map incorrect!");
        }
        return inputString;
    }
}
