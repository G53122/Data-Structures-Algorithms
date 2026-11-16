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

    






}