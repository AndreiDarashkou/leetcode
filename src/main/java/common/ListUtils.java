package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ListUtils {

    private ListUtils() {
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> list(T... elements) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, elements);

        return list;
    }

}
