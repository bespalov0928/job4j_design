package ru.job4j.chapter005.srp.report;

import java.util.List;
import java.util.function.Predicate;

public class ReportAccountant implements Report {

    private Store store;

    public ReportAccountant(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> list = store.findBy(filter);


        text.append("Name; Hired; Fired; Bonus");
        for (Employee employer : list) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";");
        }
        return text.toString();

    }
}
