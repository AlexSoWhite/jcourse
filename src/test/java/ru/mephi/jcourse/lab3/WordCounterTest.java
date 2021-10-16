package ru.mephi.jcourse.lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @org.junit.jupiter.api.Test
    void countWords() {
        String[] src = {"word1", "word1", "word1", "word1", "word1", "word1", "word1",
                "word2", "word2", "word2", "word2", "word2",
                "word3", "word3", "word3", "word3", "word3", "word3", "word3", "word3", "word3",
                "word4", "word4", "word4", "word4", "word4", "word4",
                "word5", "word5",
                "word6",
                "word7"};

        ArrayList<String> words = new ArrayList<>(Arrays.asList(src));

        HashMap<String, Integer> result = WordCounter.countWords(words);

        assertEquals(7, result.get("word1"));
        assertEquals(5, result.get("word2"));
        assertEquals(9, result.get("word3"));
        assertEquals(6, result.get("word4"));
        assertEquals(2, result.get("word5"));
        assertEquals(1, result.get("word6"));
        assertEquals(1, result.get("word7"));

    }
}