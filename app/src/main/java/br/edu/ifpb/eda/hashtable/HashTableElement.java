package br.edu.ifpb.eda.hashtable;

public class HashTableElement<K, V> {
    protected final K key;
    protected V value;

    protected HashTableElement(K key) {
        this.key = key;
        this.value = null;
    }

    protected HashTableElement(K key, V value) {
        this.key = key;
        this.value = value;
    }

    protected boolean sameKey(K anotherKey) {
        return key.equals(anotherKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass())
            return false;

        HashTableElement<K, V> anotherElement = (HashTableElement<K, V>) obj;
        return this.key.equals(anotherElement.key);
    }
}
