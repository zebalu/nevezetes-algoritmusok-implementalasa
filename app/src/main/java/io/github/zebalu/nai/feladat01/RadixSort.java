package io.github.zebalu.nai.feladat01;

import java.util.ArrayList;
import java.util.List;

final class RadixSort {
    private static final int MASK = 0b1111_1111;

    static void radixSort(final int[] array) {
        int shift = 0;
        for(int move=0; move<4; ++move, shift+=8) {
            List<Integer>[] bins = initArray();
            for (int value : array) {
                int bin = (value >>> shift) & MASK;
                bins[bin].add(value);
            }
            int i = 0;
            for (List<Integer> bin : bins) {
                for (Integer value : bin) {
                    array[i++] = value;
                }
            }
        }
    }

    private static List<Integer>[] initArray() {
        List<Integer>[] bins = new List[MASK+1];
        for(int i=0; i<=MASK; ++i) {
            bins[i] = new ArrayList<>();
        }
        return bins;
    }
}
