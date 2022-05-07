package com.app;

import com.sorting.MergeSort;
import com.sorting.QuickSort;

public class App {
    public static void main(String[] args) {
        System.out.println("------------ Merge sort -------------------");
        MergeSort mergeSort = new MergeSort();
        int mergeSortVector[] = { 90, 5, 21, 15, 19, 7, 9, 11 };
        System.out.println("Unsorted vector v = 90, 5, 21, 15, 19, 7, 9, 11");
        mergeSort.sort(mergeSortVector, 0, mergeSortVector.length - 1);
        System.out.print("Sorted vector v = ");
        for (int i = 0; i < mergeSortVector.length; i++) {
            System.out.print(mergeSortVector[i] + " ");
        }
        System.out.println();
        System.out.println("------------ Merge sort end -------------------");

        System.out.println("------------ Quick sort -------------------");
        QuickSort quickSort = new QuickSort();
        int quickSortVector[] = { 90, 5, 21, 15, 19, 7, 9, 11 };
        System.out.println("Unsorted vector v = 90, 5, 21, 15, 19, 7, 9, 11");
        quickSort.sort(quickSortVector, 0, quickSortVector.length - 1);
        System.out.print("Sorted vector v = ");
        for (int i = 0; i < quickSortVector.length; i++) {
            System.out.print(quickSortVector[i] + " ");
        }
        System.out.println();
        System.out.println("------------ Quick sort end -------------------");
    }
}
