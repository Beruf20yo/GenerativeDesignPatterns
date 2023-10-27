package ru.example.builder;

import lombok.AllArgsConstructor;

import java.util.Objects;

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
        return new PersonBuilder(name, surname, age, address);
    }

    public PersonBuilder setSurname(String surname) {
        return new PersonBuilder(name, surname, age, address);
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0) {
            return new PersonBuilder(name, surname, age, address);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public PersonBuilder setAddress(String address) {
        return new PersonBuilder(name, surname, age, address);
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
