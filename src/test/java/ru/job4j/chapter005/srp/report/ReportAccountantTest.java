package ru.job4j.chapter005.srp.report;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportAccountantTest {

    @Test
    public void generate() {

        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportAccountant engine = new ReportAccountant(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Bonus")
                //.append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(" $;");
        //.append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));

    }
}