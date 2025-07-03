package org.example.clone;

class Pair implements Cloneable{

    int i; //primitive
    Integer I; //immutable wrapper class
    String s; //immutable -> no shallow copy
    StringBuilder sb; //only this will show shallow copy

    Pair(Integer I ,int i ,String s ,StringBuilder sb){
        this.I = I;
        this.s = s;
        this.i = i;
        this.sb = sb;
    }

    @Override
    public Pair clone() {
        try {
            Pair clone = (Pair) super.clone(); //shallow copy
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        Pair p1 = new Pair(1 ,1 , "abc" ,new StringBuilder("ABC"));
        Pair p2 = p1.clone();

        System.out.println("p1 : " + p1);
        System.out.println("p2 : " + p2);
        System.out.println();

        p2.I = 2;
        p2.i = 2;
        p2.s = "xyz";
        p2.sb.append("XYZ"); //shallow copy

        System.out.println("p1 : " + p1);
        System.out.println("p2 : " + p2);
        System.out.println();

        p2.I = 3;
        p2.i = 3;
        p2.s = "pqr";
        p2.sb = new StringBuilder("PQR"); //not a shallow copy
        //if you did this ,then p1.sb still points to original "ABC"
        //p2.sb now points to new "XYZ"

        System.out.println("p1 : " + p1);
        System.out.println("p2 : " + p2);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "i=" + i +
                ", I=" + I +
                ", s='" + s + '\'' +
                ", sb=" + sb +
                '}';
    }
}
