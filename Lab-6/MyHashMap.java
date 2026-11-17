import java.util.LinkedList;

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
    public MyHashMap(int initialCapacity, float loadFactorThreshold) {
        if (initialCapacity > MAXIMUM_CAPACITY)
            this.capacity = MAXIMUM_CAPACITY; 
        else 
            this.capacity = trimToPowerOf2(initialCapacity);
        
        this.loadFactorThreshold = loadFactorThreshold; 
        table = new LinkedList[capacity];
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
    
      







}