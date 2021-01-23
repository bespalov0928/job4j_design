package ru.job4j.chapter007;

import java.io.*;
import java.util.function.Predicate;

public class ParseFile {
    private File file;

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized String getContent() throws IOException {

        String output = getContent(data -> data < 0x80);

//        String output = "";
//        StringBuilder sb = new StringBuilder(output);
//        try (InputStream i = new BufferedInputStream(new FileInputStream(file))) {
//            int data;
//            while ((data = i.read()) > 0) {
//                //output += (char) data;
//                sb.insert(0, data);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return output;
    }

    public synchronized String getContentWithoutUnicode() throws IOException {

        String output = getContent(data -> data < 0x80);

//        StringBuilder sb = new StringBuilder(output);
//        try (InputStream i = new BufferedInputStream(new FileInputStream(file))) {
//            int data;
//            while ((data = i.read()) > 0) {
//                if (data < 0x80) {
//                    //output += (char) data;
//                    sb.insert(0, data);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return output;
    }

    public synchronized String getContent(Predicate<Integer> pred) throws IOException {
        String output = "";
        StringBuilder sb = new StringBuilder(output);
        try (InputStream i = new BufferedInputStream(new FileInputStream(file))) {
            int data;
            while ((data = i.read()) > 0) {
                if (pred.test(data)) {
                    sb.insert(0, data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }

    public synchronized void saveContent(String content) throws IOException {
        try (OutputStream o = new BufferedOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < content.length(); i++) {
                o.write(content.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
