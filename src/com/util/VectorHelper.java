package com.util;

public class VectorHelper {
    private VectorHelper() {}

    public static void swapTwoVectorValuesByPosition(int[] v, int aIndex, int bIndex) {
        int temp = v[aIndex];
        v[aIndex] = v[bIndex];
        v[bIndex] = temp;
    }
}
