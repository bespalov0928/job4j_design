package ru.job4j.chapter005._tdd.template;

import java.util.Map;

public interface Generator {
    String produce(String template, Map<String, String> srgs);
}
