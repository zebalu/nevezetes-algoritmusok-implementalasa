package io.github.zebalu.nai.feladat01;

final class LumotoPartition {
    static int lumotoPartition(int[] array, int from, int to, int pivotStartIndex) {
        int pivot = array[pivotStartIndex];
        swap(array, to, pivotStartIndex);
        int i=from;
        for(int j=from; j<=to; ++j) {
            if(array[j] < pivot) {
                swap(array, i, j);
                ++i;
            }
        }
        swap(array, i, to);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
