package org.example.clone;

public class Student implements Cloneable{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Object clone() throws CloneNotSupportedException {
        //shallow copy
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Student ajju = new Student("ajju" , 19);
        Student aj = (Student) ajju.clone();


    }
}
