package io.github.zebalu.nai.feladat01;

import java.util.Arrays;

final class HoarePartition {
    private HoarePartition() {
        throw new IllegalAccessError("Utility class");
    }

    static int hoarePartition(int[] array, int from, int to, int pivotStartIndex) {
        int pivot = array[pivotStartIndex];
        swap(array, from, pivotStartIndex);
        int i = from - 1;
        int j = to + 1;
        while (i < j) {
            do {
                ++i;
            } while (array[i] < pivot && i < j);
            do {
                --j;
            } while (array[j] > pivot && j > i);
            if (i < j) {
                swap(array, i, j);
            }
        }
        return i;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
