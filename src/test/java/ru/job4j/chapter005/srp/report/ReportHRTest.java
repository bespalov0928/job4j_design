package ru.job4j.chapter005.srp.report;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportHRTest {

    @Test
    public void generate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Kate", now, now, 150);
        Employee worker2 = new Employee("Roma", now, now, 90);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);

        ReportHR engine = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
               .append("Name; Salary").append(";")
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";");
        String rsl = engine.generate(em -> true, new ReportText());
        assertThat(rsl, is(expect.toString()));

    }
}