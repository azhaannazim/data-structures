package org.example.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>>  {
    private final List<T> list;

    public Heap(){
        list = new ArrayList<>();
    }
    private void swap(int i ,int j){
        T temp = list.get(i);
        list.set(i , list.get(j));
        list.set(j , temp);
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private int left(int i){
        return 2*i + 1;
    }
    private int right(int i){
        return 2*i + 2;
    }

    public void insert(T a){
        list.add(a);
        upHeap(list.size()-1);
    }
    private void upHeap(int i) {
        if(i == 0) return ;

        int pInd = parent(i);
        if(list.get(i).compareTo(list.get(pInd)) < 0) {
            swap(i, pInd);
            upHeap(pInd);
        }
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("no element!!");
        }
        T val = list.getFirst();

        T lastVal = list.removeLast();
        if(!list.isEmpty()){
            list.set(0 , lastVal);
            downHeap(0);
        }
        return val;
    }
    private void downHeap(int i) {
        int min = i;

        int left = left(i);
        int right = right(i);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }

        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        if(min != i) {
            swap(min, i);
            downHeap(min);
        }
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
