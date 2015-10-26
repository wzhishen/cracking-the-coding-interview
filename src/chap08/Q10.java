package chap08;

import static helpers.Printer.*;

import java.util.LinkedList;

/**
 * Design and implement a hash table which uses chaining (linked
 * lists) to handle collisions.
 */
public class Q10 {
    public static class Item<K, V> {
        private K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public void setValue(V value) {
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }

    public static class HashTable<K, V> {
        private static final int BUCKETS_SIZE = 10;
        private LinkedList<Item<K, V>>[] buckets;

        @SuppressWarnings("unchecked")
        public HashTable() {
            buckets = new LinkedList[BUCKETS_SIZE];
        }

        public int getHashCode(K key) {
            return key.toString().length() % BUCKETS_SIZE;
        }

        public void put(K key, V value) {
            if (key == null) return;
            int hash = getHashCode(key);
            if (buckets[hash] == null) {
                buckets[hash] = new LinkedList<Item<K, V>>();
            }
            LinkedList<Item<K, V>> bucket = buckets[hash];
            for (Item<K, V> item : bucket) {
                if (item.getKey().equals(key)) {
                    item.setValue(value);
                    return;
                }
            }
            bucket.add(new Item<K, V>(key, value));
        }

        public V get(K key) {
            if (key == null) return null;
            int hash = getHashCode(key);
            LinkedList<Item<K, V>> bucket = buckets[hash];
            if (bucket == null) return null;
            for (Item<K, V> item : bucket) {
                if (item.getKey().equals(key)) return item.getValue();
            }
            return null;
        }

        public boolean remove(K key) {
            if (key == null) return false;
            int hash = getHashCode(key);
            LinkedList<Item<K, V>> bucket = buckets[hash];
            if (bucket == null) return false;
            for (Item<K, V> item : bucket) {
                if (item.getKey().equals(key)) {
                    bucket.remove(item);
                    return true;
                }
            }
            return false;
        }

        public void printTable() {
            for (int i = 0; i < buckets.length; ++i) {
                LinkedList<Item<K, V>> bucket = buckets[i];
                if (bucket == null) continue;
                print("[bucket " + i + "] ");
                for (Item<K, V> item : bucket) {
                    print(item.getKey() + ":" + item.getValue() + " ");
                }
                println();
            }
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        HashTable<String, Integer> map = new HashTable<String, Integer>();
        map.put("cat", 1);
        map.put("dog", 2);
        map.put("fish", 2);
        map.put("tiger", 3);
        map.put("spiderman", 4);
        map.put("averylongtruck", 5);
        map.printTable();
        println(map.get("none"));
        println(map.get("spiderman"));
        println(map.remove("none"));
        println(map.remove("spiderman"));
        println(map.get("spiderman"));
        map.printTable();
    }
}
