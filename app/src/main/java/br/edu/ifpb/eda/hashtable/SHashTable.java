package br.edu.ifpb.eda.hashtable;

public class SHashTable<K, V> implements IHashTable<K, V> {
    private int size = 1;
    private int current = 0;
    @SuppressWarnings("unchecked")
    private HashTableElement<K, V>[] data = new HashTableElement[size];

    private int getIndex(K key) {
        int hash = hash(key);
        for (int index = hash; index < size; index++)
            if (data[index] != null && data[index].sameKey(key))
                return index;
        for (int index = 0; index < hash; index++)
            if (data[index] != null && data[index].sameKey(key))
                return index;
        return -1;
    }

    private HashTableElement<K, V> getHashTableElement(K key) {
        int index = getIndex(key);
        return index == -1 ? null : data[index];
    }

    private int getNullPosition(@SuppressWarnings("rawtypes") HashTableElement[] list, int start, int end, int step) {
        int index = start;
        while (index < end && list[index] != null)
            index += step;
        return index != end ? index : -1;
    }

    private int getNullPosition(@SuppressWarnings("rawtypes") HashTableElement[] list, int start, int end) {
        return getNullPosition(list, start, end, 1);
    }

    private int getNullHashPosition(@SuppressWarnings("rawtypes") HashTableElement[] list, int hash, int size) {
        int index = getNullPosition(list, hash, size);
        return index != -1 ? index : getNullPosition(list, 0, hash);
    }

    private int getNullHashPosition(int hash) {
        return getNullHashPosition(data, hash, size);
    }

    private void resize(int size) {
        @SuppressWarnings("unchecked")
        HashTableElement<K, V>[] tmp = new HashTableElement[size];
        for (HashTableElement<K, V> element : data)
            tmp[getNullHashPosition(tmp, hash(element.key, size), size)] = element;
        this.data = tmp;
        this.size = size;
    }

    private int hash(K key, int size) {
        return key.hashCode() % size;
    }

    @Override
    public int hash(K key) {
        return hash(key, this.size);
    }

    @Override
    public void add(K key, V value) {
        if (current == size)
            resize(size << 1);
        current++;

        HashTableElement<K, V> element = new HashTableElement<>(key, value);
        data[getNullHashPosition(hash(key))] = element;
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
        current--;

        HashTableElement<K, V> element = data[index];
        data[index] = null;
        return element.value;
    }
}
