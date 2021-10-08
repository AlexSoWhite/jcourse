package ru.mephi.jcourse;

public class MyIntList {

    private int capacity;
    private int size;
    private int[] list;

    final static int block_size = 16;

    public MyIntList() {
        try {
            this.list = new int[block_size];
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        this.capacity = block_size;
        this.size = 0;
    }

    public MyIntList(int initialCapacity) {
        try {
            checkCapacity(initialCapacity);
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
        }
        try {
            this.list = new int[initialCapacity];
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        this.capacity = initialCapacity;
        this.size = 0;
    }

    public MyIntList(int initialCapacity, int source) {
        try {
            checkCapacity(initialCapacity);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            this.list = new int[initialCapacity];
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        this.capacity = initialCapacity;
        for (int i = 0; i < this.capacity; i++) {
            this.list[i] = source;
        }
        this.size = this.capacity;
    }

    public MyIntList(int... values) {
        this();
        for (int value : values) {
            this.add(value);
        }
    }

    public void add(int value) {
        if (this.size == this.capacity) {
            this.resize(1);
        }
        this.list[size] = value;
        this.size++;
    }

    public int get(int index) {
        try {
            this.checkIndex(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return this.list[index];
    }

    public void add(int value, int index) {
        try {
            this.checkIndex(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        if (this.size == this.capacity) {
            this.resize(1);
        }
        try {
            int[] newList = new int[this.capacity];
            if (index >= 0) {
                System.arraycopy(this.list, 0, newList, 0, index);
            }
            newList[index] = value;
            if (this.size + 1 - (index + 1) >= 0) {
                System.arraycopy(this.list, index + 1 - 1, newList, index + 1, this.size + 1 - (index + 1));
            }
            this.list = newList;
            this.size++;
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public int indexOf(int value) {
        for (int i = 0; i < this.size; i++) {
            if (this.list[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (this.list[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int set(int value, int index) {
        try {
            this.checkIndex(index);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        int previous = this.list[index];
        this.list[index] = value;
        return previous;
    }

    public int remove(int index) {
        try {
            this.checkIndex(index);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        int previous = this.list[index];
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

    public static MyIntList merge(MyIntList a, MyIntList b){
        MyIntList merged = new MyIntList();
        try {
            merged = new MyIntList(a.size() + b.size());
            int idx_a = 0, idx_b = 0;
            while (idx_a + idx_b < a.size() + b.size()) {
                if (idx_a != a.size() && a.get(idx_a) < b.get(idx_b)) {
                    merged.add(a.get(idx_a));
                    if (idx_a < a.size())
                        idx_a ++;
                }
                else {
                    merged.add(b.get(idx_b));
                    if (idx_b < b.size())
                        idx_b ++;
                }
            }
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return merged;
    }

    //if direction == -1 then we compress the list (decrease capacity)
    //if direction == 1 then we expand the list (increase capacity)
    private void resize(int direction) {
        try {
            int[] newList = new int[this.capacity + direction * block_size];
            this.capacity += direction * block_size;
            if (this.size >= 0) {
                System.arraycopy(this.list, 0, newList, 0, this.size);
            }
            this.list = newList;
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("incorrect index");
        }
    }

    private static void checkCapacity(int capacity){
        if (capacity < 0) {
            throw new IllegalArgumentException("illegal initial capacity");
        }
    }

}