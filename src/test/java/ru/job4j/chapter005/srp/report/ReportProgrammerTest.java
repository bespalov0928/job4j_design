package ru.job4j.chapter005.srp.report;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportProgrammerTest {

    @Test
    public void generate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Calendar now1 = new GregorianCalendar(2012,Calendar.DECEMBER,31);
        Employee worker = new Employee("Ivan", now1, now1, 100);
        Employee worker1 = new Employee("Kate", now1, now1, 150);
        store.add(worker);
        store.add(worker1);

        ReportProgrammer engine = new ReportProgrammer(store);
        String expect = "<!DOCTYPE html>\n" +
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
                "   </tr>\n" +
                "<tr>\n" +
                "<td>Ivan</td>\n" +
                "<td>java.util.GregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"Europe/Moscow\",offset=10800000,dstSavings=0,useDaylight=false,transitions=79,lastRule=null],firstDayOfWeek=2,minimalDaysInFirstWeek=4,ERA=?,YEAR=2012,MONTH=11,WEEK_OF_YEAR=?,WEEK_OF_MONTH=?,DAY_OF_MONTH=31,DAY_OF_YEAR=?,DAY_OF_WEEK=?,DAY_OF_WEEK_IN_MONTH=?,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=0,MILLISECOND=?,ZONE_OFFSET=?,DST_OFFSET=?]</td>\n" +
                "<td>java.util.GregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"Europe/Moscow\",offset=10800000,dstSavings=0,useDaylight=false,transitions=79,lastRule=null],firstDayOfWeek=2,minimalDaysInFirstWeek=4,ERA=?,YEAR=2012,MONTH=11,WEEK_OF_YEAR=?,WEEK_OF_MONTH=?,DAY_OF_MONTH=31,DAY_OF_YEAR=?,DAY_OF_WEEK=?,DAY_OF_WEEK_IN_MONTH=?,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=0,MILLISECOND=?,ZONE_OFFSET=?,DST_OFFSET=?]</td>\n" +
                "<td>100.0</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>Kate</td>\n" +
                "<td>java.util.GregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"Europe/Moscow\",offset=10800000,dstSavings=0,useDaylight=false,transitions=79,lastRule=null],firstDayOfWeek=2,minimalDaysInFirstWeek=4,ERA=?,YEAR=2012,MONTH=11,WEEK_OF_YEAR=?,WEEK_OF_MONTH=?,DAY_OF_MONTH=31,DAY_OF_YEAR=?,DAY_OF_WEEK=?,DAY_OF_WEEK_IN_MONTH=?,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=0,MILLISECOND=?,ZONE_OFFSET=?,DST_OFFSET=?]</td>\n" +
                "<td>java.util.GregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"Europe/Moscow\",offset=10800000,dstSavings=0,useDaylight=false,transitions=79,lastRule=null],firstDayOfWeek=2,minimalDaysInFirstWeek=4,ERA=?,YEAR=2012,MONTH=11,WEEK_OF_YEAR=?,WEEK_OF_MONTH=?,DAY_OF_MONTH=31,DAY_OF_YEAR=?,DAY_OF_WEEK=?,DAY_OF_WEEK_IN_MONTH=?,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=0,MILLISECOND=?,ZONE_OFFSET=?,DST_OFFSET=?]</td>\n" +
                "<td>150.0</td>\n" +
                "</tr>\n" +
                "  </table>\n" +
                " </body>\n" +
                "</html>";
        String rsl = engine.generate(em -> true, new ReportHtml());
        assertThat(rsl, is(expect));

    }
}