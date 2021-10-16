package ru.mephi.jcourse.lab3;

import java.util.ArrayList;
import java.util.HashMap;

public class WordCounter {

    public static HashMap<String, Integer> countWords(ArrayList<String> words) {

        HashMap<String, Integer> result = new HashMap<>(0);

        for (String word : words) {

            if (result.containsKey(word)) {
                Integer currValue = result.get(word);
                result.replace(word, currValue + 1);
            } else {
                result.put(word, 1);
            }

        }

        return result;
    }

}
