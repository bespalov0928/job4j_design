package ru.job4j.chapter002.Io.Logs;


//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;

import org.slf4j.*;

public class UsageLog4j {

//    private static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName());
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        String name = "Dmitrii";
        byte age = 35;
        short ageManth = 420;
        int ageDay = 12775;
        long ageMinute = 18396000;
        float weightCentner = (float) 0.765;
        double weightKg = 76.5;
        boolean working = true;
        LOG.debug("User info name : {}, age : {}, ageManth : {}, ageDay : {}, ageMinute : {}, weightCentner : {}, weightKg : {}, working : {}", name, age, ageManth, ageDay, ageMinute, weightCentner, weightKg, working);
    }
}
