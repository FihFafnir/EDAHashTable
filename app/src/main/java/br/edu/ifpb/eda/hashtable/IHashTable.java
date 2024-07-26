package br.edu.ifpb.eda.hashtable;

public interface IHashTable<K, V> {
    public int hash(K key);

    public void add(K key, V value);

    public void set(K key, V value);

    public V get(K key);

    public V remove(K key);
}
