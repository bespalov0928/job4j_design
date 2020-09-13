package ru.job4j.chapter002.Io.Serialization;

public class Contact {
    private final String phone;

    @Override
    public String toString() {
        return String.format("Contact{phone='%s'}", phone);
    }

    public Contact(String phone) {
        this.phone = phone;
    }
}
