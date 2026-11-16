
public interface MyMap<K, V> {
// Removes all values from the map.
public void clear();

// Checks to see if the given key is in the map.
public boolean containsKey(K key);

// Checks to see if the map contains the given value.
public boolean containsValue(V value);

// Returns a set of all the entries in the map.
public java.util.Set<Entry<K, V>> entrySet();

// Returns the first value that matches the given key.
public V get(K key);

// Returns "true" if the map is empty.
public boolean isEmpty();

// Returns a set that contains all the entries in the map.
public java.util.Set<K> keySet();

// Adds an entry (key, value) to the map.
public V put(K key, V value);

// Removes the entries correlated with the given key.
public void remove(K key);

// Returns the number of mappings the map.
public int size();







}