import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {

    @Test
    void add() {
        MyList myList = new MyList(10);
        String[] sa = new String[] {"s1", "s2", null};
        for (String s: sa) {
            myList.add(s);
        }
        assertEquals(3, myList.size());
    }

    @Test
    void get() {
        MyList myList = new MyList();
        String[] sa = new String[] {"s1", "s2", null};
        for (String s: sa) {
            myList.add(s);
        }
        assertEquals("s1", myList.get(-5));
        assertNull(myList.get(20));
    }

    @Test
    void testAdd() {
        MyList myList = new MyList(5, "foo");
        String[] sa = new String[] {"s1", "s2", null};
        for (int i = 0; i < 3; i ++)
            myList.add(sa[i], i);
        assertEquals("s2", myList.get(1));
    }

    @Test
    void indexOf() {
        MyList myList = new MyList(5, "foo", "abc", 16);
        assertEquals(3, myList.indexOf(16));
        assertEquals(-1, myList.indexOf(10));
    }

    @Test
    void contains() {
        MyList myList = new MyList(5, "foo", "abc", 16);
        assertTrue(myList.contains(5));
        assertFalse(myList.contains(9));
    }

    @Test
    void set() {
        MyList myList = new MyList(5, "foo", "abc", 16);
        assertEquals(5, myList.set(10, -5));
        assertEquals(10, myList.get(0));
        assertEquals(16, myList.set(15, 10));
        assertEquals(15, myList.get(3));
    }

    @Test
    void remove() {
        MyList myList = new MyList(5, "foo", "abc", 16);
        assertEquals(5, myList.remove(-5));
        assertEquals("foo", myList.get(0));
        assertEquals(16, myList.remove(15));
        assertEquals(2, myList.size());
    }

    @Test
    void size() {
        MyList myList = new MyList(100);
        assertEquals(0, myList.size());
        for (int i = 0; i < 100; i ++)
            myList.add(i);
        assertEquals(100, myList.size());
    }

    @Test
    void isEmpty() {
        MyList myList = new MyList();
        assertTrue(myList.isEmpty());
        myList.add(2);
        myList.add(2);
        myList.add(2);
        assertFalse(myList.isEmpty());
    }
}