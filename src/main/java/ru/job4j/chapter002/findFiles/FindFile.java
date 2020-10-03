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
import java.util.function.Predicate;
import java.util.regex.*;

public class FindFile {
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException(String.format("Не указан ключ поиска директории %s", "-d"));
        } else if (args.length == 1) {
            throw new IllegalArgumentException(String.format("Не указана директория поиска", ""));
        } else if (args.length == 2) {
            throw new IllegalArgumentException(String.format("не указан ключ поиска файла %s", "-n"));
        } else if (args.length == 3) {
            throw new IllegalArgumentException(String.format("не указан файл поиска", ""));
        } else if (args.length == 4) {
            throw new IllegalArgumentException(String.format("не указан ключ варианта поиска %s или %s или %s", "-m - искать по макс, либо", "-f - полное совпадение имени", "-r регулярное выражение"));
        } else if (args.length == 5) {
            throw new IllegalArgumentException(String.format("не указан ключ записи в Log файл %s", "-o"));
        } else if (args.length == 6) {
            throw new IllegalArgumentException(String.format("Не указан путь к файлу Log", ""));
        }

        String wayFind = args[1];   //-d - директория в которая начинать поиск.
        String fileFind = args[3];//"*.txt";//args[3];  //-n - имя файл, маска, либо регулярное выражение.
        String searchBy = args[4]; //"-m";//args[4];  //-m - искать по маск, либо -f - полное совпадение имени. -r регулярное выражение.
        String log = args[6];//"C:\\projects\\job4j_design\\log.txt";//args[6];       //-o - результат записать в файл.

        Path paathFileFind = Paths.get(wayFind);
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
        FileFisitClass fileFisitClass = new FileFisitClass(fileFind, predicate);

        try {
            Files.walkFileTree(paathFileFind, fileFisitClass);
        } catch (IOException e) {
            //e.printStackTrace();
            LOG.error("Ошибка поиска файла", e);
        }

        try (BufferedWriter out = new BufferedWriter(new FileWriter(log, true));
        ) {
            out.write(String.format("-d %s -n %s -m -o $s", wayFind, fileFind, log));
            for (Path str : fileFisitClass.getList()) {
                out.write(str + System.lineSeparator());
            }
        } catch (IOException e) {
            //e.printStackTrace();
            LOG.error("Ошибка записи LOG файла", e);
        }
        fileFisitClass.getList().forEach(System.out::println);
    }
}
