package com.company;

import java.util.HashMap;
import java.util.Map;

public class LruCache<K, V> {

    /**
     * Коллекция, реализующая LRU кеш.
     *
    // * @param <K> Тип ключей
    // * @param <V> Тип значений
     */

    class Value<V> {
        private V val;
        private int freq;

        public Value(V val) {
            this.val = val;
            this.freq = 0;
        }

        public V getVal() {
            return val;
        }

        public int getFreq() {
            return freq;
        }

        public void addFreq() {
            freq++;
        }
    }

    public LruCache(int maxSize) {
        this.maxSize = maxSize;
        this.currSize = 0;
    }

    private Map<K, Value> map = new HashMap<K, Value>();
    private int maxSize;
    private int currSize = 0;

    public void set(K key, V val) {
        Value<V> value = new Value<>(val);
        if (currSize == maxSize) {
            K delKey = getEldest();
            map.remove(delKey);
        }
        map.put(key, value);

    }
    private K getEldest(){
        int min = 999;
        K minKey = null;
        for (Map.Entry<K, Value> entry: map.entrySet()) {
            if (entry.getValue().getFreq() < min) {
                min = entry.getValue().getFreq();
                minKey = entry.getKey();
            }
        }
        return minKey;
    }
    public V get(K key){
        map.get(key).addFreq();
        return (V) map.get(key).getVal();
    }
    public int getLimit() {
        return maxSize;
    }

    public int getSize() {
        return currSize;
    }

    /**
     * Возвращает значение, соответствующее указанному ключу.
     * При этом элемент (пара ключ-значение) помечается
     * как последний использованный.
     *
   //  * @param key Ключ
     * @return Значение или {@code null},
     * если значение не найдено
     */


    /**
     * Добавляет элемент (пару ключ-значение) в коллекцию.
     * В случае, если элемент с таким ключом уже был
     * в коллекции, он заменяется.
     * При этом элемент помечается как последний использованный.
     * <p>
     * В случае, если до вставки размер коллекции был равен
     * максимальному, из нее удаляется элемент,
     * неиспользованный дольше всех.
     *
     /* @param key   Ключ
     /* @param value Значение
     *              Рекомендации по реализации программы
     *              Постарайтесь найти решение, оптимальное с точки зрения
     *              алгоритмической сложности операций чтения и записи. Подумайте об
     *              использовании двух других, уже известных вам структур данных.
     */
    //void set(K key, V value);

    /**
     * Возвращает текущий размер коллекции.
     *
     * @return Текущий размер
     */
   // int getSize();

    /**
     * Возвращает максимальный размер коллекции.
     *
     * @return Максимальный размер
     */
    //int getLimit();

    //private int freq;
}
