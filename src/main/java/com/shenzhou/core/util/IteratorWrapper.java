package com.shenzhou.core.util;

import java.util.Iterator;


public abstract class IteratorWrapper<E>
        implements Iterator<E> {
    private final Iterator<E> iterator;

    public IteratorWrapper(Iterator<E> iterator) {
        if (iterator == null) {
            throw new IllegalArgumentException();
        }
        this.iterator = iterator;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public E next() {
        return this.iterator.next();
    }

    public void remove() {
        this.iterator.remove();
    }
}
