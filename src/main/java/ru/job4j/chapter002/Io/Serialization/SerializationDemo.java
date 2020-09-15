package ru.job4j.chapter002.Io.Serialization;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {

        //произвести сериализацию объекта
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("serial"))) {
            MyClass object1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("object1: " + object1);
            out.writeObject(object1);
        } catch (IOException e) {
            System.out.println("Иссключение при сериализации: " + e);
        }

        //произвести десиреализацию объекта
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("serial"))) {
            MyClass object2 = (MyClass) in.readObject();
            System.out.println("object2: " + object2);
        } catch (Exception e) {
            System.out.println("исключение при десиарилизации объекта: " + e);
            System.exit(0);
        }
    }
}
