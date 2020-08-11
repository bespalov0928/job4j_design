package ru.job4j.chapter001.map;

import java.util.*;

public class HashMapNew<K, V> implements Iterable<K> {

    private int size = 16;
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
                while (point < table.length && table[point] == null) {
                    point++;
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

        enlargingTable();

        boolean rsl = false;
        int hash = key.hashCode();
        int index = calculateIndex(hash);
        Node<K, V> p;
        if (table[index] == null) {
            p = new Node<K, V>(hash, key, value, null);
            table[index] = p;
            sizemax++;
            modCount++;
            rsl = true;
        } else {
            if (Objects.equals(key, table[index].key)) {
                table[index].value = value;
                rsl = true;
            }
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
        V value = null;
        int index = calculateIndex(key.hashCode());
        Node<K, V> tmp = table[index];
        if (Objects.equals(key, tmp.key)) {
            value = tmp.value;
        }
        return value;
    }

    /**
     * удалить значение
     *
     * @param key
     * @return
     */
    public boolean delete(K key) {
        boolean rsl = false;
        int index = calculateIndex(key.hashCode());
        if (table[index] != null && Objects.equals(key, table[index].key)) {
            table[index] = null;
            sizemax--;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    public void enlargingTable() {

        if (sizemax / table.length >= DEFAULT_LOAD_FACTOR) {
            size = size * 2;
            Node<K, V>[] oldTable = table;
            table = new Node[size];
            for (int x = 0; x < oldTable.length; x++) {
                Node<K, V> nodeTmp = oldTable[x];
                if (nodeTmp == null) {
                    continue;
                }
                int index = calculateIndex(nodeTmp.hash);
                table[index] = nodeTmp;
            }
        }
    }

    public int calculateIndex(int hash) {
        int index = hash & (table.length - 1);
        return index;
    }
}
