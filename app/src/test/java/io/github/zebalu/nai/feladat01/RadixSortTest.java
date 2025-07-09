package io.github.zebalu.nai.feladat01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.function.Consumer;
import java.util.random.RandomGenerator;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {

    @Test
    void testRadixSort() {
        int[] array = {0xffffff + 4, 1, 7, 3, 300, 270, 260, 1_000, 18_000, 11_000, 22_000};
        RadixSort.radixSort(array);
        List<Executable> toTest = new ArrayList<>();
        for (int i = 0; i < array.length - 1; ++i) {
            int ii = i;
            toTest.add(() -> assertTrue(array[ii] < array[ii + 1], "array[" + ii + "]=" + array[ii] + " should be less then array[" + (ii + 1) + "]=" + array[ii + 1]));
        }
        assertAll(toTest);
    }
}