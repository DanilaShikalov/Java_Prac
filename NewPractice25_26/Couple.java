package com.company.NewPractice25_26;

public class Couple<K, V> {
    private K key;
    private V value;

    public Couple(K key, V value) {
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Couple{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
