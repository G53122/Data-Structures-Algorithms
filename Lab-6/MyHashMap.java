import java.util.LinkedList;

import javax.management.RuntimeErrorException;

public class MyHashMap<K, V> implements MyMap<K, V> {
    // Defines the default size of the hash table.
    private final static int DEFAULT_INITIAL_CAPACITY = 4; 

    // Defines the maximum size of the hash table.
    private final static int MAXIMUM_CAPACITY = 1 << 30; 

    // Represents the current capacity of the hash table.
    private int capacity; 

    // Defines the default load factor of the table.
    private final static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;

    // Specifies the load factor to be used. 
    private float loadFactorThreshold; 

    // Represents the number of entries in the map.
    private int size = 0; 

    // Defines the Hash Table as an array with linked-list cells.
    LinkedList<MyMap.Entry<K,V>>[] table;

    // Creates a map with the default capacity and load factor.
    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR); 
    }

    // Creates a map with the specified initial capacity and the default load factor.
    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }

    // Creates a map with the specified initial capacity and load factor.
    public MyHashMap(int initialCapacity, float loadFactorThreshold) {
        if (initialCapacity > MAXIMUM_CAPACITY)
            this.capacity = MAXIMUM_CAPACITY; 
        else 
            this.capacity = trimToPowerOf2(initialCapacity);
        
        this.loadFactorThreshold = loadFactorThreshold; 
        table = new LinkedList[capacity];
    }

    // Removes all of the entries from the map.
    @Override 
    public void clear() {
        size = 0; 
        removeEntries();
    }

    // Returns true if the specified key is in the map.
    @Override 
    public boolean containsKey(K key) {
        if(get(key) != null)
            return true; 
        else 
            return false; 
    }

    // Returns true if the specified value is in the map.
    @Override 
    public boolean containsValue(V value) {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K, V> entry: bucket)
                    if (entry.getValue().equals(value))
                        return true;
            }
        }
        return false;
    }

    // Returns a set of entries in the map.
    @Override 
    public java.util.Set<MyMap.Entry<K, V>> entrySet() {
        java.util.Set<MyMap.Entry<K, V>> set =
            new java.util.HashSet<>(); 
        
        for (int i = 0; i < capacity; i++) {
            if(table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K, V> entry: bucket)
                    set.add(entry);
            }
        }
        return set; 
    }

    // Return the value that matches the specified key.
    @Override 
    public V get(K key) {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] != null) {
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            for (Entry<K, V> entry: bucket)
                if (entry.getKey().equals(key))
                    return entry.getValue(); 
        }
        return null;
    }

    // Returns true if map contains no entries.
    @Override 
    public boolean isEmpty() {
        return size == 0; 
    }

    // Returns a set that contains all the keys in the map.
    @Override 
    public java.util.Set<K> keySet() {
        java.util.Set<K> set = new java.util.HashSet<>(); 

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K, V> entry: bucket) 
                    set.add(entry.getKey());
            }
        }
        return set;
    }


    // Adds an entry (key, value) into the map.
    @Override
    public V put(K key, V value) {
        if (get(key) != null ) { // Key is already in the map.
            int bucketIndex = hash(key.hashCode());
            LinkedList<Entry<K, V>> bucket = table[bucketIndex]; 
            for (Entry<K, V> entry: bucket)
                if (entry.getKey().equals(key)) {
                    V oldValue = entry.getValue(); 
                    // Replaces old value with new value.
                    entry.value = value;
                    // Returns old value for the key.
                    return oldValue; 
                }
        }

    // Checks the laod factor 

    if (size >= capacity * loadFactorThreshold) {
        if (capacity == MAXIMUM_CAPACITY)
            throw new RuntimeException("Exceeding maximum capacity"); 

        rehash(); 
    }

    int bucketIndex = hash(key.hashCode());

    // Create a linked list for the bucket if it's not already created.
    if (table[bucketIndex] == null) {
        table[bucketIndex] = new LinkedList<Entry<K, V>>();
    }

    // Add a new entry (key, value) to hashTable[index].
    table[bucketIndex].add(new MyMap.Entry<K, V>(key, value)); 
    size++; // Increase size. 
    return value; 
}

// Remove the entry for the specified key.
@Override 
public void remove(K key) {
    int bucketIndex = hash(key.hashCode());

// Remove the entry that matches the key from the bucket.
if (table[bucketIndex] != null) {
    LinkedList<Entry<K, V>> bucket = table[bucketIndex];
    for (Entry<K, V> entry: bucket)
        if (entry.getKey().equals(key)) {
            bucket.remove(entry); 
            size--; // Decrease size.
            break; // No need to continue in loop.
        }
}
}


// Return the number of entries in the map.
@Override 
public int size() {
    return size;
}

// Return a set with all the values in the map.
@Override 
public java.util.Set<V> values() {
    java.util.Set<V> set = new java.util.HashSet<>(); 

    for (int i = 0; i < capacity; i++) {
        if (table[i] != null) {
            LinkedList<Entry<K, V>> bucket = table[i];
            for (Entry<K, V> entry: bucket) 
                set.add(entry.getValue());
        }
    }
    return set;
}

// Hash function.
private int hash(int hashCode) {
    return supplementalHash(hashCode) & (capacity - 1); 
}

// Ensures that hashing is even. 
private static int supplementalHash(int h) {
    h ^= (h >>> 20) ^ (h >>> 12);
    return h ^ (h >>> 7) ^ (h >>> 4);
}

// Return power of 2 for initialCapacity.
private int trimToPowerOf2(int initialCapacity) {
    int capacity = 1; 
    while (capacity < initialCapacity); {
    capacity <<= 1; 
    }
    return capacity;
}

// Removes all entries from each bucket.
private void removeEntries() {
    for (int i = 0; i < capacity; i++) {
        if (table[i] != null) {
            table[i].clear(); 
        }
    }
}

// Rehash the map.
private void rehash() {
    java.util.Set<Entry<K, V>> set = entrySet(); // Gets entries
    capacity <<= 1; // Double capacity.
    table = new LinkedList[capacity]; // Create a new hash table.
    size = 0; // Reset size to 0. 

    for (Entry<K, V> entry: set) {
        put(entry.getKey(), entry.getValue()); // Store to new table.
    }
}

@Override 
public String toString() {
    StringBuilder builder = new StringBuilder("["); 

    for (int i = 0; i < capacity; i++) {
        if (table[i] != null && table[i].size() > 0)
            for (Entry<K, V> entry: table[i])
                builder.append(entry);
    }
    builder.append("]");
    return builder.toString();
}










}