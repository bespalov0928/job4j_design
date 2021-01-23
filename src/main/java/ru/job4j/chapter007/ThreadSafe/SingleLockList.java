package ru.job4j.chapter007.ThreadSafe;

import net.jcip.annotations.ThreadSafe;

import java.io.*;
import java.util.Iterator;

@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {

    private DynamicList array = new DynamicList();

    public synchronized void add(T value) {

    }

    public synchronized T get(int index) {
        return null;
    }

    public DynamicList copy(DynamicList array) throws IOException, ClassNotFoundException {
        DynamicList<T> arrayCopy = new DynamicList<>();
        while (array.iterator().hasNext()) {
            T elArray = (T) array.iterator().next();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream ous = null;
            ous = new ObjectOutputStream(baos);
            ous.writeObject(elArray);
            ous.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            T cloneElArray = (T) ois.readObject();
            arrayCopy.add(cloneElArray);
        }
        return arrayCopy;
    }

    @Override
    public synchronized Iterator<T> iterator() {
        Iterator<T> rsl = null;
        try {
            rsl = copy(this.array).iterator();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rsl;
    }
}
