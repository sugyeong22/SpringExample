package com.sudal.springexample.lifecycle;

public class Person {

    // 이름, 나이
    private String name;
    private Integer age;

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }

    @Override
    public String toString(){
        return "이름 : " + name + " 나이 : " + age;
    }
}
