package challenge.april.week2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3706/
 * <p>
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may
 * also be integers or other lists. Implement an iterator to flatten it.
 */
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
