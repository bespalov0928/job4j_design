package ru.job4j.chapter005.srp.report;

import java.util.List;
import java.util.function.Predicate;

public class ReportHtml implements TypeReports {
    @Override
    public String generate(List<String> list) {
        String[] arrString = list.get(0).split(";");
//        for (String string : arrCap) {
//            StringBuilder cap = new StringBuilder();
//            cap.append(String.format("<th>%s</th>\n", string));
//        }

//        for (int index = 1; index < list.size(); index++) {
//            arrCap = list.get(index).split(";");
//            StringBuilder table = new StringBuilder();
//            table.append("tr>\n");
//            for (String string : arrCap) {
//                table.append(String.format("<td>%s</td>\n", string));
//            }
//            table.append("</tr>\n");
//        }

        String rsl = "";
        //List<Employee> list = store.findBy(filter);
        StringBuilder text = new StringBuilder();
        text.append(
                "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        " <head>\n" +
                        "  <meta charset=\"utf-8\">\n" +
                        "  <title>Тег table</title>\n" +
                        " </head>\n" +
                        " <body>\n" +
                        "  <table border=\"1\">\n" +
                        "   <tr>\n");

        for (String string : arrString) {
            StringBuilder cap = new StringBuilder();
            text.append(String.format("<th>%s</th>\n", string));
        }
//                        "    <th>Name</th>\n" +
//                        "    <th>Hired</th>\n" +
//                        "    <th>Fired</th>\n" +
//                        "    <th>Salary</th>\n" +
        text.append("   </tr>\n");

        for (int index = 1; index < list.size(); index++) {
            arrString = list.get(index).split(";");
            text.append("tr>\n");
            for (String string : arrString) {
                text.append(String.format("<td>%s</td>\n", string));
            }
            text.append("</tr>\n");
        }

//        for (Employee employer : list) {
//            String table = String.format("<tr>\n<td>%s</td>\n<td>%s</td>\n<td>%s</td>\n<td>%s</td>\n</tr>\n", employer.getName(), employer.getHired(), employer.getFired(), employer.getSalary());
//            text.append(table);
//        }

        //text.append("&table\n")
        text.append("  </table>\n" +
                " </body>\n" +
                "</html>");


        return text.toString();


    }
}
