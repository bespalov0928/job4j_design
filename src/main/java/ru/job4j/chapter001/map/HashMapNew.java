package ru.job4j.chapter001.map;

import java.util.*;

public class HashMapNew<K, V> implements Iterable<K> {

    private int size = 2;
    private int sizemax = 0;
    transient Node<K, V>[] table;

    public HashMapNew() {
        this.table = new Node[size];
    }

    @Override
    public Iterator<K> iterator() {
        Iterator<K> it = new Iterator<K>() {
            int x = 0;

            @Override
            public boolean hasNext() {
                return x < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<K, V> node = table[x];
                x++;
                //System.out.println(value);
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

        if (sizemax >= size) {
            size = size * 2;
            table = Arrays.copyOf(table, size);
            for (int x = 0; x < table.length; x++) {
                if (table[x] != null) {
                    Node nodeTemp = (Node) table[x];
                    table[x] = null;
                    table[nodeTemp.hash & (table.length - 1)] = nodeTemp;
                }
            }
        }

        boolean rsl = true;
        int hash = key.hashCode() * 31;
        int index = hash & (table.length - 1);
        Node<K, V> p;
        if (table[index] == null) {
            p = new Node<K, V>(hash, key, value, null);
            table[index] = p;
            sizemax++;
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
        Iterator<K> iterator = iterator();
        V tmp = null;
        while (iterator.hasNext()) {
            Node<K, V> node = (Node<K, V>) iterator.next();
            if (node != null && node.key.equals(key)) {
                tmp = node.value;
                break;
            }
        }
        return tmp;
    }

    /**
     * удалить значение
     *
     * @param key
     * @return
     */
    public boolean delete(K key) {
        boolean rsl = false;
        Iterator<K> iterator = iterator();
        V tmp = null;
        while (iterator.hasNext()) {
            Node<K, V> node = (Node<K, V>) iterator.next();
            if (node != null && node.key.equals(key)) {
                for (int x = 0; x < table.length; x++) {
                    if (table[x] != null && table[x].equals(node)) {
                        table[x] = null;
                        rsl = true;
                        break;
                    }
                }
            }
        }
        return rsl;
    }

}
