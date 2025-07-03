package org.example;

import java.util.List;

class Animal {
    static { //will execute before main()
        System.out.println("hi !!");
    }


    Animal(){
        System.out.println("animal constructor");
    }
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    Dog(){
        System.out.println("dog constructor");
    }
    void bark(){
        System.out.println("dog bark");
    }
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
       Animal p = new Dog(); //every constructor starts by calling super() implicitly
       p.sound();
//       p.bark(); //reference type decide what can be accessed
       //streams
//        List<String> names = List.of("Azhaan", "Nashit", "Shayan", "Ali");
//
//        names.stream()                  // Source
//                .filter(s -> s.startsWith("A"))     // Intermediate
//                .map(String::toUpperCase)           // Intermediate
//                .forEach(System.out::println);      // Terminal
    }
}