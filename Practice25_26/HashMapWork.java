package com.company.Practice25_26;

import java.util.ArrayList;
import java.util.Iterator;

public class HashMapWork <K, V> implements HashMapInterface<K,V> {
    private ArrayList<Couple<K, V>> couples = new ArrayList<>();

    @Override
    public void add(K key, V value) {
        if (couples.size() != 0) {
            for (int i = 0; i < couples.size(); i++) {
                if (couples.get(i).getKey().equals(key)) {
                    couples.get(i).setValue(value);
                    break;
                }
                couples.add(new Couple<>(key, value));
            }
        }
        if (couples.size() == 0)
        {
            couples.add(new Couple<>(key, value));
        }
    }


    @Override
    public V get(K key) {
        for (int i = 0; i < couples.size(); i++)
        {
            if (couples.get(i).getKey().equals(key))
                return couples.get(i).getValue();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        for (int i = 0; i < couples.size(); i++)
        {
            if (couples.get(i).getKey().equals(key))
                couples.remove(i);
        }
        return null;
    }

    @Override
    public Iterator<V> iterator() {
        return new IteratorHashMap<V>();
    }

    private class IteratorHashMap<V> implements Iterator<V>
    {
        int Index = 0;

        @Override
        public boolean hasNext() {
            if (Index < couples.size())
                return true;
            else {
                Index = 0;
                return false;
            }
        }

        @Override
        public V next() {
            return (V) couples.get(Index++).getValue();
        }
    }
}
