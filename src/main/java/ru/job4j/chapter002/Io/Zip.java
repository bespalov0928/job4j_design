package ru.job4j.chapter002.Io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//
//        Zip zip = new Zip();
//        for (File file : sources) {
//            zip.packSingleFile(file, target);
//        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ArgZip argZip = new ArgZip(args);
        String directory = argZip.directory();
        String exclude = argZip.exclude();
        String out = argZip.out();
        List<File> list = new ArrayList<>();

        Path start = Paths.get(directory);
        Search searchClass = new Search();
        List<Path> listTmp = searchClass.search(start, exclude);
        for (Path path : listTmp) {
            list.add(path.toFile());
        }


        Zip zip = new Zip();
        zip.packFiles(list, new File(out));

//        new Zip().packSingleFile(
//                new File("./chapter_005/pom.xml"),
//                new File("./chapter_005/pom.zip")
//        );
    }
}
