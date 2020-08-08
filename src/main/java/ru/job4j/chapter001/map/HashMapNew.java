package ru.job4j.chapter001.map;

import java.util.*;

public class HashMapNew<K, V> implements Iterable<K> {

    private int size = 2;
    private int sizemax = 0;
    private int modCount = 0;
    transient Node<K, V>[] table;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public HashMapNew() {
        this.table = new Node[size];
    }

    @Override
    public Iterator<K> iterator() {
        Iterator<K> it = new Iterator<K>() {
            int point = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean rsl = false;
                if (point < table.length && table[point] == null) {
                    while (point < table.length && table[point] == null) {
                        point++;
                    }
                }
                rsl = point < table.length;

                return rsl;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                Node<K, V> node = table[point];
                point++;
                return (K) node;
            }
        };
        return it;
    }

    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * вставить значение
     *
     * @param key
     * @param value
     * @return
     */
    public boolean insert(K key, V value) {

        if (sizemax / table.length >= DEFAULT_LOAD_FACTOR) {
            enlargingTable();
        }

        boolean rsl = true;
        int hash = key.hashCode() * 31;
        int index = hash & (table.length - 1);
        Node<K, V> p;
        if (table[index] == null) {
            p = new Node<K, V>(hash, key, value, null);
            table[index] = p;
            sizemax++;
            modCount++;
        } else {
            rsl = false;
        }
        return rsl;
    }

    /**
     * получить значение
     *
     * @param key
     * @return
     */
    public V get(K key) {
        int index = key.hashCode() & (table.length - 1);
        Node<K, V> tmp = table[index];
        return tmp.value;
    }

    /**
     * удалить значение
     *
     * @param key
     * @return
     */
    public boolean delete(K key) {
        boolean rsl = false;
        int index = key.hashCode() & (table.length - 1);
        if (table[index] != null) {
            table[index] = null;
            sizemax--;
            modCount--;
            rsl = true;
        }
        return rsl;
    }

    public void enlargingTable() {

        size = size * 2;
        //table = Arrays.copyOf(table, size);
        for (int x = 0; x < table.length; x++) {
            if (table[x] != null) {
                Node nodeTemp = (Node) table[x];
                table[x] = null;
                table[nodeTemp.hash & (table.length - 1)] = nodeTemp;
            }
        }
    }
}
