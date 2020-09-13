package ru.job4j.chapter002.Io.Serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CarSerialization {
    public static void main(String[] args) {
        final Car car = new Car(true, 430, "Man", new Owner("ООО Рога и копыта"), new String[]{"Иванов", "Петров"});

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));

        /* Модифицируем json-строку */
        final String carJson = String.format("{\"truck\":%s,\"power\":%s,\"brand\":\"%s\",\"owner\":{\"name\":\"%s\"},\"drivers\":[\"Иванов\",\"Петров\"]}", "true", "430", "Man", "ООО Рога и копыта");
        System.out.println(carJson);
        final Car carMod = gson.fromJson(carJson, Car.class);
        System.out.println(carMod);

    }
}
