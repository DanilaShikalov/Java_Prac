package com.company.NewPractice25_26;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Iterator;

public class HashMap<K, V> implements HashMapInterface<K, V> {
    private ArrayList<ArrayList<Couple<K, V>>> couples = new ArrayList<>();
    private ArrayList<V> values = new ArrayList<>();

    @Override
    public void add(K key, V value) {
        for (int i = 0; i < 100; i++)
            couples.add(new ArrayList<Couple<K, V>>());
        if (couples.get(key.hashCode() % couples.size()).size() == 0)
        {
            couples.get(key.hashCode() % couples.size()).add(new Couple<K, V>(key, value));
            values.add(value);
        }
        else if (couples.get(key.hashCode() % couples.size()).size() != 0) {
            for (int i = 0; i < couples.get(key.hashCode() % couples.size()).size(); i++)
            {
                if (key.hashCode() == couples.get(key.hashCode() % couples.size()).get(i).getKey().hashCode())
                {
                    for (int j = 0; j < values.size(); j++)
                    {
                        if (values.get(j) == couples.get(key.hashCode() % couples.size()).get(i).getValue())
                        {
                            values.set(j, value);
                            break;
                        }
                    }
                    couples.get(key.hashCode() % couples.size()).set(i, new Couple<K, V>(key, value));
                    break;
                }
                else
                {
                    couples.get(key.hashCode() % couples.size()).add(couples.get(key.hashCode() % couples.size()).get(i));
                    values.add(value);
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        Couple<K, V> couple = null;
        if (couples.get(key.hashCode() % couples.size()) != null)
        {
            if (couples.get(key.hashCode() % couples.size()).size() != 0)
                couple = couples.get(key.hashCode() % couples.size()).get(couples.get(key.hashCode() % couples.size()).size()-1);
        }
        //System.out.println(couple.getValue());
        if (couple != null)
            return couple.getValue();
        else return null;
        /////////
//        if (couples.get(key.hashCode() % couples.size()) != null)
//        {
//            if (couples.get(key.hashCode() % couples.size()).size() != 0)
//            {
//                if (couples.get(key.hashCode() % couples.size()).get(key.hashCode() % couples.size() - 1) != null)
//                {
//                    return couples.get(key.hashCode() % couples.size()).get(key.hashCode() % couples.size() - 1).getValue();
//                }
//            }
//        }
//        return null;
    }

    @Override
    public V remove(K key) {
        Couple<K, V> couple = null;
        if (couples.get(key.hashCode() % couples.size()) != null)
        {
            if (couples.get(key.hashCode() % couples.size()).size() != 0)
                couple = couples.get(key.hashCode() % couples.size()).get(couples.get(key.hashCode() % couples.size()).size()-1);
        }
        if (couple != null)
        {
            couples.get(key.hashCode() % couples.size()).remove(couple);
            values.remove(get(key));
        }
        return null;
    }

    @Override
    public Iterator<V> iterator() {
        return new IteratorOfValue<V>();
    }

    private class IteratorOfValue<V> implements Iterator<V>
    {

        int currentIndex = 0;
        @Override
        public boolean hasNext() {
            if(currentIndex < values.size())
                return true;
            else
            {
                currentIndex = 0;
                return false;
            }
        }

        @Override
        public V next() {
            return (V) values.get(currentIndex++);
        }
    }
}
