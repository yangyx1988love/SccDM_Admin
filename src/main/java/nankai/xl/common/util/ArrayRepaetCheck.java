package nankai.xl.common.util;

import java.util.HashSet;

public class ArrayRepaetCheck {
    public static boolean cheakIsRepeat(Integer[] array) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }
        if (hashSet.size() == array.length) {
            return true;
        } else {
            return false;
        }
    }
}
