package ru.job4j.chapter005.srp.report;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ReportEngine implements Report {
    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter, TypeReports typeReports) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Name; Hired; Fired; Salary");
        for (Employee employer : store.findBy(filter)) {
            StringBuilder text = new StringBuilder();
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";");
            list.add(text.toString());
        }

        String rsl = typeReports.generate(list);
        return rsl;

//        StringBuilder text = new StringBuilder();
//        text.append("Name; Hired; Fired; Salary");
//        for (Employee employer : store.findBy(filter)) {
//            text.append(employer.getName()).append(";")
//                    .append(employer.getHired()).append(";")
//                    .append(employer.getFired()).append(";")
//                    .append(employer.getSalary()).append(";");
//        }
//        return text.toString();
    }
}
