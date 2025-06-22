package org.example;

import java.util.Arrays;

public class ArrayList<T> {
    private Object[] data;
    private static final int DEFAULT_SIZE = 10;
    private int size = 0;

    public ArrayList(){
        data = new Object[DEFAULT_SIZE];
    }
    public void add(T value){
        if(isFull()){
            resize();
        }
        data[size++] = value;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    private void resize() {
        Object[] temp = new Object[2 * data.length];

        for(int i=0;i<data.length;i++){
            temp[i] = data[i];
        }
        data = temp;
    }
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        return (T) data[index];
    }
    public void set(int index , T value){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        data[index] = value;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<50;i++){
            list.add(i);
        }
//        list.get(52);
        System.out.println(list);
    }
}
