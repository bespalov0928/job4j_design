package ru.job4j.chapter002.Io.Serialization;

import com.google.gson.*;

public class PersonSerialization {

    /** @noinspection checkstyle:OperatorWrap*/
    public static void main(String[] args) {
        String[] arr = new String[]{"sdfsdf"};
        final Person person = new Person(false, 30, new Contact("11-11"), new String[]{"Worker", "Married"});
        //final Person person = new Person(30, new Contact("11-11"), new String[]{"Worker", "Married"});

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        /* Модифицируем json-строку */
//        final  String personJson = "{"
//                + "\"sex\":false,"
//                + "\"age\":35,"
//                + "\"contact\":"
//                + "{"
//                + "\"phone\":\"+7(924)111-111-11-11\""
//                + "},"
//                + "\"statuses\":"
//                + "[\"Student\",\"Free\"]"
//                + "}";
        final String personJson = String.format("{" +
                "\"sex\":%s," +
                "\"age\":%s," +
                "\"contact\":{\"phone\":\"%s\"}," +
                "\"statuses\":[\"Student\",\"Free\"]" +
                "}", "false", "35", "+7(924)111-111-11-11");
        System.out.println(personJson);
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
    }

}
