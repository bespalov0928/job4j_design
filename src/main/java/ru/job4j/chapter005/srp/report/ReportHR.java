package ru.job4j.chapter005.srp.report;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportHR implements Report {
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> list = store.findBy(filter);
        MemStore memStore = new MemStore();
        list.sort((first, second) -> Integer.compare((int) second.getSalary(), (int) first.getSalary()));
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary");
        for (Employee employer : list) {
            text.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";");
        }
        return text.toString();

    }
}
