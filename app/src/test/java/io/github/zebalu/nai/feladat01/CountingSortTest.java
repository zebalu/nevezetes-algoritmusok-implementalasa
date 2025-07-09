package io.github.zebalu.nai.feladat01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {

    @Test
    void countingSortSortsCorrectly() {
        int[] array = new int[]{1, 2, 3, 1, 4, 1, 2, 1, 4, 1, 1, 2, 1};
        CountingSort.countingSort(array);
        assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 4, 4}, array);
    }

}