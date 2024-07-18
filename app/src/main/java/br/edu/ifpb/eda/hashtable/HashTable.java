package br.edu.ifpb.eda.hashtable;

import br.edu.ifpb.eda.linkedlist.LinkedList;

public class HashTable<K, V> implements IHashTable<K, V> {
    private final int NUMBER_OF_COLUMNS = 32;
    @SuppressWarnings("unchecked")
    private final LinkedList<HashTableElement<K, V>>[] data = new LinkedList[NUMBER_OF_COLUMNS];

    private HashTableElement<K, V> getHashTableElement(K key) {
        for (HashTableElement<K, V> element : data[hash(key)])
            if (element.sameKey(key))
                return element;
        return null;
    }

    private int getIndex(K key) {
        HashTableElement<K, V> element = new HashTableElement<>(key);
        int hashCode = hash(key);
        return data[hashCode].indexOf(element);
    }

    @Override
    public int hash(K key) {
        return key.hashCode() % NUMBER_OF_COLUMNS;
    }

    @Override
    public void add(K key, V value) {
        HashTableElement<K, V> element = new HashTableElement<>(key, value);
        int hashCode = hash(key);
        if (data[hashCode] == null)
            data[hashCode] = new LinkedList<HashTableElement<K, V>>();
        data[hash(key)].addLast(element);
    }

    @Override
    public void set(K key, V value) {
        HashTableElement<K, V> element = getHashTableElement(key);
        if (element == null)
            add(key, value);
        else
            element.value = value;
    }

    @Override
    public V get(K key) {
        HashTableElement<K, V> element = getHashTableElement(key);
        return element == null ? null : element.value;
    }

    @Override
    public V remove(K key) {
        int index = getIndex(key);
        if (index < 0)
            return null;

        HashTableElement<K, V> element = data[hash(key)].remove(index);
        return element.value;
    }
}
