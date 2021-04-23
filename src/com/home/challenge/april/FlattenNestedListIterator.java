package com.home.challenge.april;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        iterator = getElements(nestedList).iterator();
    }

    private List<Integer> getElements(List<NestedInteger> list) {
        List<Integer> result = new ArrayList<>();
        for (NestedInteger element : list) {
            if (element.isInteger()) {
                result.add(element.getInteger());
            } else if (!element.getList().isEmpty()) {
                result.addAll(getElements(element.getList()));
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

}
