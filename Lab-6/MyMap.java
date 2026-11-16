
public interface MyMap<K, V> {
// Removes all values from the map.
public void clear();

// Checks to see if the given key is in the map.
public boolean containsKey(K key);

// Checks to see if the map contains the given value.
public boolean containsValue(V value);

// Returns a set of all the entries in the map.
public java.util.Set<Entry<K, V>> entrySet();




}