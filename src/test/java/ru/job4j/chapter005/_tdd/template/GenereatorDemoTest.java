package ru.job4j.chapter005._tdd.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GenereatorDemoTest {

    @Test
    public void produce() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> srgs = new HashMap<>();
        srgs.put("name", "Petr Arsentev");
        srgs.put("subject", "you");
        Generator generator = new GenereatorDemo();
        String rsl = generator.produce(template, srgs);
        String expected = "I am a Petr Arsentev, Who are you?";
        assertThat(expected, is(rsl));
    }

    //в шаблоне ключей больше чем в карте
    @Test(expected = NullPointerException.class)
    public void produceVariant1() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> srgs = new HashMap<>();
        srgs.put("name", "Petr Arsentev");
        Generator generator = new GenereatorDemo();
        generator.produce(template, srgs);
    }

    //в карте больше ключей чем в шаблоне
    @Test(expected = NullPointerException.class)
    public void produceVariant2() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> srgs = new HashMap<>();
        srgs.put("name", "Petr ");
        srgs.put("subject", "you");
        srgs.put("lastName", "Arsentev");
        Generator generator = new GenereatorDemo();
        generator.produce(template, srgs);
    }

}