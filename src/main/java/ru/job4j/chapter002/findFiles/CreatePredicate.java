package ru.job4j.chapter002.findFiles;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreatePredicate {
    public static Predicate newPredicate(String searchBy, String fileFind, String wayFind) {
        Predicate predicate = new Predicate<Path>() {
            @Override
            public boolean test(Path o) {
                boolean rsl = false;
                if (searchBy.equals("-m")) {
                    rsl = o.toFile().getName().endsWith(fileFind.substring(2));
                } else if (searchBy.equals("-f")) {
                    rsl = o.toFile().getName().equals(fileFind);
                } else if (searchBy.equals("-r")) {
                    Pattern p = Pattern.compile(fileFind);
                    Matcher m = p.matcher(wayFind);
                    rsl = m.matches();
                }
                return rsl;
            }
        };
        return predicate;
    }
}
