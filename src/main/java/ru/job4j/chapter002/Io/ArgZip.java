package ru.job4j.chapter002.Io;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    /**
     * проверка входных параметров
     *
     * @return
     */
    public boolean valid() {
        boolean rsl = false;
        if (args.length < 6) {
            throw new IllegalArgumentException("Missing parameters");
        }
        rsl = true;
        return rsl;
    }

    /**
     * директория которую мы хотим архивировать
     *
     * @return
     */
    public String directory() {

        return args[1];
    }

    /**
     * исключить файлы *.xml
     *
     * @return
     */
    public String exclude() {
        return args[3];
    }

    /**
     * во что мы архивируем
     *
     * @return
     */
    public String out() {
        return args[5];
    }
}
