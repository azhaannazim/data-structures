package org.example;

import org.example.heap.Heap;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> pq = new Heap<>();
        pq.insert(9);
        pq.insert(3);
        pq.insert(99);
        pq.insert(911);
        pq.insert(-9);
        pq.insert(923);
        pq.insert(59);
        pq.insert(9);

        while (!pq.isEmpty()){
            System.out.print(pq.remove() + " ");
        }
    }
}