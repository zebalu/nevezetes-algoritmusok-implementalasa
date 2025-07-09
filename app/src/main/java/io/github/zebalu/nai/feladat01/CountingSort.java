package io.github.zebalu.nai.feladat01;

import java.util.Arrays;

final class CountingSort {
    private CountingSort() {
        throw new IllegalAccessError("Utility class");
    }
    static void countingSort(int[] array, int max) {
        int[] c = new int[max + 1];
        Arrays.fill(c, 0);
        for (int i = 0; i < array.length; ++i) {
            ++c[array[i]];
        }
        for (int i = 1; i < c.length; ++i) {
            c[i] += c[i - 1];
        }
        int[] b = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            b[c[array[i]] - 1] = array[i];
            --c[array[i]];
        }
        for (int i = 0; i < b.length; ++i) {
            array[i] = b[i];
        }
    }

    static void countingSort(int[] array) {
        countingSort(array, findMax(array));
    }

    private static int findMax(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("array is empty");
        }
        int max = array[0];
        for(int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
