package april.common;

import april.week2.NestedInteger;
import java.util.Collections;
import java.util.List;

public class NestedIntegerImpl implements NestedInteger {

    private Integer val;
    private List<NestedInteger> list;

    public NestedIntegerImpl(Integer val) {
        this.val = val;
    }

    public NestedIntegerImpl(List<NestedInteger> list) {
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return val != null;
    }

    @Override
    public Integer getInteger() {
        return list == null ? val : null;
    }

    @Override
    public List<NestedInteger> getList() {
        return list != null ? list : Collections.emptyList();
    }
}