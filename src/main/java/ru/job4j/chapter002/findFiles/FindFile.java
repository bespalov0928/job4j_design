package ru.job4j.chapter002.findFiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.chapter002.Io.Logs.UsageLog4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.*;

public class FindFile {
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        Args.check(args);

        String wayFind = args[1];   //-d - директория в которая начинать поиск.
        String fileFind = args[3];//"*.txt";//args[3];  //-n - имя файл, маска, либо регулярное выражение.
        String searchBy = args[4]; //"-m";//args[4];  //-m - искать по маск, либо -f - полное совпадение имени. -r регулярное выражение.
        String log = args[6];//"C:\\projects\\job4j_design\\log.txt";//args[6];       //-o - результат записать в файл.

        Path paathFileFind = Paths.get(wayFind);
        Predicate predicate = CreatePredicate.newPredicate(searchBy, fileFind, wayFind);
        FileFisitClass fileFisitClass = new FileFisitClass(fileFind, predicate);

        try {
            Files.walkFileTree(paathFileFind, fileFisitClass);
        } catch (IOException e) {
            //e.printStackTrace();
            LOG.error("Ошибка поиска файла", e);
        }

        List<Path> list = fileFisitClass.getList();
        save(list, log, wayFind, fileFind);
    }

    private static void save(List<Path> list, String log, String wayFind, String fileFind) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(log, true));
        ) {
            out.write(String.format("-d %s -n %s -m -o $s", wayFind, fileFind, log));
            for (Path str : list) {
                out.write(str + System.lineSeparator());
            }
        } catch (IOException e) {
            //e.printStackTrace();
            LOG.error("Ошибка записи LOG файла", e);
        }
        list.forEach(System.out::println);
    }

}
