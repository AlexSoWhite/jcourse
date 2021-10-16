package ru.mephi.jcourse.lab2;

public class Node {
    private final Object key;
    private final Object value;

    Node(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }
}

