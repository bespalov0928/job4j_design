package ru.job4j.chapter005.srp.report;

import java.util.List;
import java.util.function.Predicate;

public interface Store {
    List<Employee> findBy(Predicate<Employee> filter);
}
