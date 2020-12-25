package ru.job4j.chapter005.srp.report;

import java.util.List;
import java.util.function.Predicate;

public class ReportJson implements TypeReports {
    @Override
    public String generate(List<String> list) {
        String[] arrString = list.get(0).split(";");
        StringBuilder text = new StringBuilder();
        text.append("{")
                .append("\"nobody\": {")
                .append("\"heder\": {")
                .append("\"row\": [");
        for (String string : arrString) {
            text.append(String.format("\"%s\"\n", string));
        }
        //"name",
        //"salary"
        text.append("]")
                .append("},")
                .append("\"table\": {")
                .append("\"row\": [");
        for (int index = 1; index < list.size(); index++) {
            arrString = list.get(index).split(";");
            for (String string : arrString) {
                text.append(String.format("\"%s\"\n", string));
            }
        }
        //"name1",
        //"salary1"
        text.append("]")
                .append("}")
                .append("}")
                .append("}");

        return text.toString();
    }
}
