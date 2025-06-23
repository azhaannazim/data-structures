package org.example.hashmap;

public class Entity<K , V> {
    K key;
    V value;

    Entity(K key ,V value){
        this.key = key;
        this.value = value;
    }
}
