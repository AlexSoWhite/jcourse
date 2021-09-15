package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        // write your code here
        MyList list = new MyList(4);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add("asdasd");
        list.add(5.23);
        list.add('c', 3);
        System.out.println(list.remove(15));
        System.out.println(list.indexOf("asdasd"));
        System.out.println(list.set("string", ));
        System.out.println(list.get(1));
    }
}

final class MyList{
    private int capacity;
    private int size;
    private Object[] list;
//    public MyList(){
//        this.List = new ArrayList<Integer>();
//        this.capacity = 0;
//        this.size = 0;
//    }
    public MyList(int initialCapacity){
        this.list = new Object[initialCapacity];
        this.capacity = initialCapacity;
        this.size = 0;
    }

    //public MyList(int capacity, int )
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
        if (size == capacity){
            this.expand();
        }
        Object[] newList = new Object[this.capacity];
        for (int i = 0; i < index; i ++)
            newList[i] = this.list[i];
        newList[index] = value;
        for (int i = index+1; i <= size; i++)
            newList[i] = this.list[i-1];
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
        for (int i = index; i < size-1; i ++)
            this.list[i] = this.list[i+1];
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
        for (int i = 0; i < this.size; i++)
            newList[i] = this.list[i];
        this.list = newList;
    }

    private int getRightIndex(int index){
        if(index < 0)
            return 0;
        if (index > size - 1)
            return size - 1;
        return index;
    }

}