package org.jmorla.render;

import java.util.Arrays;

public class ArrayUtils {

    public static <T> T[] merge(T[] a, T[] b) {
        T[] result = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
    
}
