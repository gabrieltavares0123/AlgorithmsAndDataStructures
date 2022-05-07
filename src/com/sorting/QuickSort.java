package com.sorting;

import com.util.VectorHelper;

public class QuickSort {
    private int partition(int[] v, int start, int end) {
        int i = start;
        int pivot = v[start];

        for (int j = start + 1; j <= end; j++) {
            if (v[j] <= pivot) {
                i++;
                VectorHelper.swapTwoVectorValuesByPosition(v, i, j);
            }
        }

        VectorHelper.swapTwoVectorValuesByPosition(v, start, i);

        return i;
    }

    public void sort(int[] v, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(v, start, end);
            sort(v, start, pivotIndex - 1);
            sort(v, pivotIndex + 1, end);
        }
    }
}
