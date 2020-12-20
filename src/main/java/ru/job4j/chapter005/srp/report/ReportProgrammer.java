package ru.job4j.chapter005.srp.report;

import java.lang.invoke.StringConcatFactory;
import java.util.List;
import java.util.function.Predicate;

public class ReportProgrammer implements Report {
    private Store store;

    public ReportProgrammer(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String rsl = "";
        List<Employee> list = store.findBy(filter);
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
                        "   <tr>\n" +
                        "    <th>Name</th>\n" +
                        "    <th>Hired</th>\n" +
                        "    <th>Fired</th>\n" +
                        "    <th>Salary</th>\n" +
                        "   </tr>\n");

        for (Employee employer : list) {
            String table = String.format("<tr>\n<td>%s</td>\n<td>%s</td>\n<td>%s</td>\n<td>%s</td>\n</tr>\n", employer.getName(), employer.getHired(), employer.getFired(), employer.getSalary());
            text.append(table);
        }

        //text.append("&table\n")
        text.append("  </table>\n" +
                " </body>\n" +
                "</html>");


//        StringBuilder table = new StringBuilder();
//        for (Employee employer : list) {
//            table.append(String.format("<tr>\n<td>%s</td>\n<td>%s</td>\n\t<td>%s</td>\n\t<td>%s</td>\n</tr>", employer.getName(), employer.getHired(), employer.getFired(), employer.getSalary()));
//        }


//        rsl = text.toString();
//        rsl.replace("&table\n", table.toString());

        return text.toString();
    }
}
