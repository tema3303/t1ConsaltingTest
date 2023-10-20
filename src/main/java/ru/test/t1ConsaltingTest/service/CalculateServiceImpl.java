package ru.test.t1ConsaltingTest.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CalculateServiceImpl implements CalculateService {

    @Override
    public HashMap<String, Integer> getCalculateString(String input) {
        HashMap<String, Integer> result = new HashMap<>();
        int count;
        for (int i = 0; i < input.length(); i++) {
            if (!result.containsKey(String.valueOf(input.charAt(i)))) {
                result.put(String.valueOf(input.charAt(i)), 1);
            } else if (result.containsKey(String.valueOf(input.charAt(i)))) {
                count = result.get(String.valueOf((input.charAt(i)))) + 1;
                result.put(String.valueOf(input.charAt(i)), count);
            }
        }
        return result.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.
                        toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));
    }
}