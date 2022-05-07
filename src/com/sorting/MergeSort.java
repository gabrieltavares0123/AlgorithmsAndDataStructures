package com.sorting;

public class MergeSort {
    private void merge(int[] v, int start, int middle, int end) {
        int[] helper = new int[v.length];
        for (int i = 0; i < v.length; i++) helper[i] = v[i];

        int i = start;
        int j = middle + 1;
        int k = start;

        while (i <= middle && j <= end) {
            if (helper[i] < helper[j]) {
                v[k] = helper[i];
                i++;
            } else {
                v[k] = helper[j];
                j++;
            }

            k++;
        }

        while (i <= middle) {
            v[k] = helper[i];
            i++;
            k++;
        }

        while (j <= middle) {
            v[k] = helper[j];
            j++;
            k++;
        }
    }

    public void sort(int[] v, int start, int end) {
        if (start >= end) return;

        else {
            int middle = (start + end) / 2;
            sort(v, start, middle);
            sort(v, middle + 1, end);

            merge(v, start, middle, end);
        }
    }
}
