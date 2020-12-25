package ru.job4j.chapter005.srp.report;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ReportAccountant implements Report {

    private Store store;

    public ReportAccountant(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter, TypeReports typeReports) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Name; Hired; Fired; Bonus");
        for (Employee employer : store.findBy(filter)) {
            StringBuilder text = new StringBuilder();
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(" $;");
            list.add(text.toString());
        }
        String rsl = typeReports.generate(list);
        return rsl;

//        text.append("Name; Hired; Fired; Bonus");
//        for (Employee employer : list) {
//            text.append(employer.getName()).append(";")
//                    .append(employer.getHired()).append(";")
//                    .append(employer.getFired()).append(";")
//                    .append(employer.getSalary()).append(" $;");
//        }
//        return text.toString();

    }
}
