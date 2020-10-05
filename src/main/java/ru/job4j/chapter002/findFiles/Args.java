package ru.job4j.chapter002.findFiles;

public class Args {
    public static void check(String[] args) {
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
    }
}
