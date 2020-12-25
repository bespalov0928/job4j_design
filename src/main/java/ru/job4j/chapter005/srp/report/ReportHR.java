package ru.job4j.chapter005.srp.report;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportHR implements Report {
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter, TypeReports typeReports) {
        List<Employee> listEmp = store.findBy(filter);
        listEmp.sort((first, second) -> Integer.compare((int) second.getSalary(), (int) first.getSalary()));

        ArrayList<String> list = new ArrayList<>();
        list.add("Name; Salary");
        for (Employee employer : listEmp) {
            StringBuilder text = new StringBuilder();
            text.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";");
            list.add(text.toString());
        }
        String rsl = typeReports.generate(list);
        return rsl;

//        List<Employee> list = store.findBy(filter);
//        MemStore memStore = new MemStore();
//        list.sort((first, second) -> Integer.compare((int) second.getSalary(), (int) first.getSalary()));
//        StringBuilder text = new StringBuilder();
//        text.append("Name; Salary");
//        for (Employee employer : list) {
//            text.append(employer.getName()).append(";")
//                    .append(employer.getSalary()).append(";");
//        }
//        return text.toString();

    }
}
