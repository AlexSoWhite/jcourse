package ru.mephi.jcourse;

public class MyList {

    private int capacity;
    private int size;
    private Object[] list;

    final static int block_size = 16;

    public MyList() {
        this.list = new Object[block_size];
        this.capacity = block_size;
        this.size = 0;
    }

    public MyList(int initialCapacity) {
        this.list = new Object[initialCapacity];
        this.capacity = initialCapacity;
        this.size = 0;
    }

    public MyList(int initialCapacity, Object source) {
        this.list = new Object[initialCapacity];
        this.capacity = initialCapacity;
        for (int i = 0; i < capacity; i++) {
            this.list[i] = source;
        }
        this.size = capacity;
    }

    public MyList(Object... values) {
        this();
        for (Object value : values) {
            this.add(value);
        }
    }

    public void add(Object value) {
        if (size == capacity) {
            this.resize(1);
        }
        this.list[size] = value;
        this.size++;
    }

    public Object get(int index) {
        index = this.getRightIndex(index);
        return this.list[index];
    }

    public void add(Object value, int index) {
        index = this.getRightIndex(index);
        if (size == capacity) {
            this.resize(1);
        }
        Object[] newList = new Object[this.capacity];
        if (index >= 0) {
            System.arraycopy(this.list, 0, newList, 0, index);
        }
        newList[index] = value;
        if (size + 1 - (index + 1) >= 0) {
            System.arraycopy(this.list, index + 1 - 1, newList, index + 1, size + 1 - (index + 1));
        }
        this.list = newList;
        this.size++;
    }

    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (this.list[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (this.list[i] == value) {
                return true;
            }
        }
        return false;
    }

    public Object set(Object value, int index) {
        index = this.getRightIndex(index);
        Object previous = this.list[index];
        this.list[index] = value;
        return previous;
    }

    public Object remove(int index) {
        index = this.getRightIndex(index);
        Object previous = this.list[index];
        if (size - 1 - index >= 0) {
            System.arraycopy(this.list, index + 1, this.list, index, size - 1 - index);
        }
        this.size--;
        if (this.capacity - this.size > 16) {
            this.resize(-1);
        }
        return previous;
    }

    public int size() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    //if direction == -1 then we compress the list (decrease capacity)
    //if direction == 1 then we expand the list (increase capacity)
    private void resize(int direction) {
        Object[] newList = new Object[this.capacity + direction * block_size];
        this.capacity += direction * block_size;
        if (this.size >= 0) {
            System.arraycopy(this.list, 0, newList, 0, this.size);
        }
        this.list = newList;
    }

    private int getRightIndex(int index) {
        if (index < 0) {
            return 0;
        }
        return Math.min(index, size - 1);
    }

}