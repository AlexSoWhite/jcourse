package ru.mephi.jcourse;

import static org.junit.jupiter.api.Assertions.*;

class MyIntListTest {

    @org.junit.jupiter.api.Test
    void merge() {
        MyIntList a = new MyIntList(1, 3, 5, 7, 10, 15, 20);
        MyIntList b = new MyIntList(2, 8, 13, 16, 18, 21, 25);
        MyIntList expected = new MyIntList(1, 2, 3, 5, 7, 8, 10, 13, 15, 16, 18, 20, 21, 25);
        MyIntList merged = MyIntList.merge(a, b);
        for (int i = 0; i < expected.size(); i ++)
            assertEquals(expected.get(i), merged.get(i));
    }
}