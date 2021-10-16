package ru.mephi.jcourse.lab2;
import ru.mephi.jcourse.lab1.MyList;

public class Map {
    private final MyList list;

    Map() {
        this.list = new MyList();
    }

    public void put(Object key, Object value) {
        this.list.add(new Node(key, value));
    }

    public Object get(Object key) {
        for (int i = 0; i < this.list.size(); i++) {
            Node curr = (Node) this.list.get(i);
            if (curr.getKey().equals(key)) {
                return curr.getValue();
            }
        }
        return null;
    }

    public Object get(Object key, Object bydefault) {
        int sz = this.list.size();
        for (int i = 0; i < sz; i++) {
            Node curr = (Node) this.list.get(i);
            if (curr.getKey().equals(key))
                return curr.getValue() == null ? bydefault : curr.getValue();
        }
        return bydefault;
    }

    public Object remove(Object key) {
        int sz = this.list.size();
        for (int i = 0; i < sz; i++) {
            Node curr = (Node) this.list.get(i);
            if (curr.getKey() == key) {
                curr = (Node) this.list.remove(i);
                return curr.getValue();
            }
        }
        return null;
    }

    public boolean keyContains(Object key) {
        int sz = this.list.size();
        for (int i = 0; i < sz; i++) {
            Node curr = (Node) this.list.get(i);
            if (curr.getKey() == key) {
                return true;
            }
        }
        return false;
    }

    public MyList getKeys() {
        int sz = this.list.size();
        MyList keys = new MyList();
        for (int i = 0; i < sz; i++) {
            Node curr = (Node) this.list.get(i);
            keys.add(curr.getKey());
        }
        return keys;
    }

    public MyList getValues() {
        int sz = this.list.size();
        MyList values = new MyList();
        for (int i = 0; i < sz; i++) {
            Node curr = (Node) this.list.get(i);
            values.add(curr.getValue());
        }
        return values;
    }

    public MyList getEntries() {
        int sz = this.list.size();
        MyList entries = new MyList();
        for (int i = 0; i < sz; i++) {
            Node curr = (Node) this.list.get(i);
            entries.add(curr);
        }
        return entries;
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

}
