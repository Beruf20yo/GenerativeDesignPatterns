package ru.example.builder;

import lombok.AllArgsConstructor;

import java.util.Objects;
import java.util.OptionalInt;

@AllArgsConstructor
public class PersonBuilder implements IPersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder() {
    }

    public PersonBuilder(String surname, int age, String cityOfResidence) {
        this.surname = surname;
        this.age = age;
        this.address = cityOfResidence;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0) {
            this.age = age;
            return this;
        } else {
            throw new IllegalArgumentException();
        }
        }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() {

        if (Objects.nonNull(name) || Objects.nonNull(surname)) {
            return new Person(name, surname, age, address);
        } else {
            throw new IllegalStateException();
        }
    }
}
