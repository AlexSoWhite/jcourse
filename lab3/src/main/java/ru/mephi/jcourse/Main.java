package ru.mephi.jcourse;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        System.out.println("to end input please press:\n\nEnter + ctrl+D\n\notherwise result will be incorrect");

        Scanner scan = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>(0);

//       end input by
//       enter + ctrl+D
//       otherwise result will be incorrect

        while (scan.hasNext()) {
            words.add(scan.next());
        }

        Set<Map.Entry<String, Integer>> res = WordCounter.countWords(words).entrySet();

        for (Map.Entry<String, Integer> entry : res) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

}
