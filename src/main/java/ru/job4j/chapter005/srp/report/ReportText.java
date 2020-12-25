package ru.job4j.chapter005.srp.report;

import java.util.List;
import java.util.function.Predicate;

public class ReportText implements TypeReports {
    @Override
    public String generate(List<String> list) {
        StringBuilder text = new StringBuilder();
        for (int index = 0; index < list.size(); index++) {
            String[] arr = list.get(index).split(";");
            for (String arrString : arr) {
                text.append(arrString).append(";");
            }
        }
        return text.toString();
    }
}
