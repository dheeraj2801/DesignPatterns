package CustomDataStructures;
import java.util.Objects;

class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] buckets;
    private int size = 0;

    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
        buckets = new Entry[INITIAL_CAPACITY];
    }

    private int getBucketIndex(K key) {
        return Math.abs(Objects.hashCode(key))%buckets.length;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Entry<K, V> head = buckets[index];

        for(Entry<K, V> current = head; current != null; current = current.next) {
            if (Objects.equals(current.key, key)) {
                current.value = value;
                return;
            }
        }

        Entry<K, V> newEntry = new Entry<>(key, value, head);
        buckets[index] = newEntry;
        size++;

        if ((float) size / buckets.length >= LOAD_FACTOR) {
            resize();
        }
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> head = buckets[index];

        for(Entry<K, V> current = head; current != null; current = current.next) {
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
        }

        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    public void resize() {
        Entry<K, V>[] oldBuckets = buckets;
        buckets =  new Entry[oldBuckets.length * 2];
        size = 0;

        for(Entry<K, V> bucket: oldBuckets) {
            for(Entry<K, V> entry = bucket; entry != null; entry = entry.next) {
                put(entry.key, entry.value);
            }
        }
    }
}


public class CustomHashMap {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);

        System.out.println("apple: " + map.get("apple"));   // 10
        System.out.println("banana: " + map.get("banana")); // 20
        System.out.println("Contains 'cherry'? " + map.containsKey("cherry")); // true
        System.out.println("Size: " + map.size()); // 3
    }
}
