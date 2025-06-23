package org.example.hashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K , V> {
    ArrayList<LinkedList<Entity<K , V>>> list;
    private int size = 0;

    private float lf = 0.5f; //load factor : above which map size will get double

    public HashMap(){
        list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(new LinkedList<>());
        }
    }
    public void put(K key ,V value){
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity<K , V>> branch = list.get(hash);

        for(Entity<K,V> entity : branch){
            if(entity.key.equals(key)){
                entity.value = value;
                return;
            }
        }
        branch.add(new Entity<>(key , value));
        size++;

        if((float)(size) / list.size() > lf) {
            reHash();
        }
    }

    private void reHash() {
        ArrayList<LinkedList<Entity<K , V>>> old = list;
        list = new ArrayList<>();
        size = 0;

        for(int i=0;i<old.size() * 2;i++){
            list.add(new LinkedList<>());
        }
        for(LinkedList<Entity<K , V>> branch : old){
            for(Entity<K , V> entity : branch){
                put(entity.key , entity.value);
            }
        }
    }

    public V get(K key){
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity<K, V>> branch = list.get(hash);
        for(Entity<K , V> entity : branch){
            if(entity.key.equals(key)){
                return entity.value;
            }
        }
        return null;
    }
    public boolean containsKey(K key){
        return get(key) != null;
    }
    public boolean remove(K key){
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity<K, V>> branch = list.get(hash);
        Entity target = null;
        for(Entity<K , V> entity : branch){
            if(entity.key.equals(key)){
                target = entity;
                break;
            }
        }
        return branch.remove(target);
    }
}
