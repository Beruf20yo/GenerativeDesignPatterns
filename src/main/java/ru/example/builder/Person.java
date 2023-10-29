package ru.example.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.OptionalInt;

@AllArgsConstructor

public class Person {
    @Getter
    private String name;
    @Getter
    private String surname;
    private int age = -1;
    @Setter
    @Getter
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public OptionalInt getAge(){
        return OptionalInt.of(age);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder(surname, 0, address);
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        } else {
            System.out.println("Возраст не задан");
        }
    }


    public boolean hasAge() {
        return age>=0;
    }

    public boolean hasAddress() {
        return Objects.nonNull(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
