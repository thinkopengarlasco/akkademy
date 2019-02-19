package it.services.utils;

import java.util.Comparator;

public class Comparatore<T extends Comparable<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return (o1.compareTo(o2)) * (-1);
    }
}
