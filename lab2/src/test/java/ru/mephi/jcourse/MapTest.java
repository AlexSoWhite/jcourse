package ru.mephi.jcourse;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @org.junit.jupiter.api.Test
    void put() {
        Map map = new Map();
        map.put(1, 2);
        map.put(2, 1);
        map.put("asd", 90);
        map.put(6, 'c');
        assertEquals(1, map.get(2));
        assertEquals(90, map.get("asd"));
        assertNull(map.get(19));
        assertEquals(4, map.size());
    }


    @org.junit.jupiter.api.Test
    void testGet() {
        Map map = new Map();
        map.put(1, 2);
        map.put(2, 1);
        map.put("asd", 90);
        map.put(6, 'c');
        assertEquals(1, map.get(2, 1));
        assertEquals(90, map.get("asd", 45));
        assertEquals("def", map.get(19, "def"));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        Map map = new Map();
        map.put(1, 2);
        map.put(2, 1);
        map.put("asd", 90);
        map.put(6, 'c');
        assertEquals(1, map.remove(2));
        assertEquals(90, map.remove("asd"));
        assertNull(map.remove(5));
        assertEquals(2, map.size());
    }

    @org.junit.jupiter.api.Test
    void keyContains() {
        Map map = new Map();
        map.put(1, 2);
        map.put(2, 1);
        map.put("asd", 90);
        map.put(6, 'c');
        assertTrue(map.keyContains(1));
        assertFalse(map.keyContains("aasd"));
    }

    @org.junit.jupiter.api.Test
    void getKeys() {
        Map map = new Map();
        map.put(1, 2);
        map.put(2, 1);
        map.put("asd", 90);
        map.put(6, 'c');
        MyList keys = new MyList(1, 2, "asd", 6);
        MyList got = map.getKeys();
        for (int i = 0; i < got.size(); i++) {
            assertEquals(keys.get(i), got.get(i));
        }
    }
}