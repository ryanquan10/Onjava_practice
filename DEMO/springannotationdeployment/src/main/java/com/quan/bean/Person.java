package com.quan.bean;

public class Person {
    public   String first;
    public   String last;
    public   String address;

    public Person() {
    }

    static{
        System.out.println("加载Person");
    }

    public Person(String first, String last, String address) {
        System.out.println("Person构造器");
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public String toString(){
        return "Person: "+first+" "+last+" "+address;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
