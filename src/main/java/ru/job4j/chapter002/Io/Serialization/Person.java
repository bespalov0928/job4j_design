package ru.job4j.chapter002.Io.Serialization;

public class Person {
    private final boolean sex;
    private final int age;
    private final Contact contact;
    private final String[] statuses;

    public Person(boolean sex, int age, Contact contact, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }
//    public Person(int age, Contact contact, String[] statuses) {
//        this.age = age;
//        this.contact = contact;
//        this.statuses = statuses;
//    }

    @Override
    public String toString() {
        return String.format("Person{sex=%s, age=%s, contact=%s, statuses=%s}", sex, age, contact, statuses);
        //return String.format("Person{age=%s, contact=%s, statuses=%s}", age, contact, statuses);
    }
}
