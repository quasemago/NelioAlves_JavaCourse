package service;

import java.util.List;

public class CalculationService {
    public static <T extends Comparable<? super T>> T getMostExpensiveItem(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("List can't be empty!");
        }

        T mostExpensiveItem = null;
        for (T item : list) {
            if (mostExpensiveItem == null || item.compareTo(mostExpensiveItem) > 0) {
                mostExpensiveItem = item;
            }
        }
        return mostExpensiveItem;
    }
}
