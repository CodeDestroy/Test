package com.company;

public class Main {

    public static void main(String[] args) {
	    LruCache<Integer, Integer> map = new LruCache<Integer, Integer>(4);
        map.set(1, 1);
        map.set(2, 2);
        map.set(3, 3);
        map.set(4, 4);
        map.set(5, 5);
        System.out.println(map.get(4));
    }
}
