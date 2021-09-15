public class Main {

    public static void main(String[] args) {
//        MyList list = new MyList(4);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add("asdasd");
//        list.add(5.23);
//        list.add('c', 3);
//        System.out.println(list.remove(15));
//        System.out.println(list.indexOf("asdasd"));
//        System.out.println(list.set("string", 2));
//        System.out.println(list.get(1));
//        System.out.println(list.contains(5.23));
//        System.out.println(list.size());
//        System.out.println(list.isEmpty());
    }
}

final class MyList{
    private int capacity;
    private int size;
    private Object[] list;
    public MyList(){
        this.list = new Object[5];
        this.capacity = 5;
        this.size = 0;
    }

    public MyList(int initialCapacity){
        this.list = new Object[initialCapacity];
        this.capacity = initialCapacity;
        this.size = 0;
    }

    public MyList(int initialCapacity, Object source){
        this.list = new Object[initialCapacity];
        this.capacity = initialCapacity;
        for (int i = 0; i < capacity; i++)
            this.list[i] = source;
        this.size = capacity;
    }

    public MyList(Object... values){
        this();
        for (Object value : values)
            this.add(value);
    }
    public void add(Object value){
        if (size == capacity){
            this.expand();
        }
        this.list[size] = value;
        this.size++;
    }

    public Object get(int index){
        index = this.getRightIndex(index);
        return this.list[index];
    }

    public void add(Object value, int index){
        index = this.getRightIndex(index);
        if (size == capacity)
            this.expand();
        Object[] newList = new Object[this.capacity];
        if (index >= 0) System.arraycopy(this.list, 0, newList, 0, index);
        newList[index] = value;
        if (size + 1 - (index + 1) >= 0)
            System.arraycopy(this.list, index + 1 - 1, newList, index + 1, size + 1 - (index + 1));
        this.list = newList;
        this.size ++;
    }

    public int indexOf(Object value){
        for (int i = 0; i < size; i ++)
            if(this.list[i] == value)
                return i;
        return -1;
    }

    public boolean contains(Object value){
        for (int i = 0; i < size; i ++)
            if(this.list[i] == value)
                return true;
        return false;
    }

    public Object set(Object value, int index){
        index = this.getRightIndex(index);
        Object previous = this.list[index];
        this.list[index] = value;
        return  previous;
    }

    public Object remove(int index){
        index = this.getRightIndex(index);
        Object previous = this.list[index];
        if (size - 1 - index >= 0) System.arraycopy(this.list, index + 1, this.list, index, size - 1 - index);
        this.size--;
        return previous;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    private void expand(){
        Object[] newList = new Object[this.capacity*2];
        this.capacity *= 2;
        if (this.size >= 0) System.arraycopy(this.list, 0, newList, 0, this.size);
        this.list = newList;
    }

    private int getRightIndex(int index){
        if(index < 0)
            return 0;
        return Math.min(index, size - 1);
    }

}