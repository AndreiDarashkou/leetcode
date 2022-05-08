package medium;

import common.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 * <p>
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may
 * also be integers or other lists. Implement an iterator to flatten it.
 */
public class NestedIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        iterator = toList(nestedList).iterator();
    }

    private static List<Integer> toList(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        for (NestedInteger nested : nestedList) {
            if (nested.isInteger()) {
                list.add(nested.getInteger());
            } else {
                list.addAll(toList(nested.getList()));
            }
        }
        return list;
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
