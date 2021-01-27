package ru.job4j.chapter007.ThreadSafe;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {
    @GuardedBy("this")
    private final DynamicList array = new DynamicList();

    public synchronized void add(T value) {
        array.add(value);
    }

    public synchronized T get(int index) {
        return (T) array.get(index);
    }

    public synchronized DynamicList copy(DynamicList array) throws IOException, ClassNotFoundException {

        DynamicList<T> arrayCopy = new DynamicList<>();
        Iterator<T> iter = array.iterator();


        while (iter.hasNext()) {
            T elArray = iter.next();
            arrayCopy.add(elArray);
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ObjectOutputStream ous = null;
//            ous = new ObjectOutputStream(baos);
//            ous.writeObject(elArray);
//            ous.close();
//            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
//            ObjectInputStream ois = new ObjectInputStream(bais);
//            T cloneElArray = (T) ois.readObject();
//            arrayCopy.add(cloneElArray);
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
