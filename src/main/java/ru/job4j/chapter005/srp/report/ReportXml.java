package ru.job4j.chapter005.srp.report;

import java.util.List;
import java.util.function.Predicate;

public class ReportXml implements TypeReports {
    @Override
    public String generate(List<String> list) {
        String[] arrString = list.get(0).split(";");
        StringBuilder text = new StringBuilder();
        text.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        text.append("<nobody>");
        text.append("<heder>");
        for (String string : arrString) {
            text.append(String.format("<row>%s</row>\n", string));
        }

        text.append("</heder>");
        text.append("<table>");
        for (int index = 1; index < list.size(); index++) {
            arrString = list.get(index).split(";");
            for (String string : arrString) {
                text.append(String.format("<row>%s</row>\n", string));
            }
        }

        text.append("</table>");
        text.append("</nobody>");
        return text.toString();
    }
}
