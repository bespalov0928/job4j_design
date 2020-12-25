package ru.job4j.chapter005.srp.report;

import java.util.function.Predicate;

public interface Report {

    public String generate(Predicate<Employee> filter, TypeReports typeReports);
}
