package io.github.zebalu.nai.feladat01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HoarePartitionTest {

    @Test
    void arrayCorrectlyArrangedAroundPivot() {
        int[] array = new int[]{1, 9, 2, 8, 7, 3, 4, 5, 6};
        int pivot = array[7];
        int idx = HoarePartition.hoarePartition(array, 0, 8, 7);
        List<Executable> tests = new ArrayList<>();
        for (int i = 0; i < idx; i++) {
            int le = i;
            tests.add(() -> assertTrue(array[le] <= pivot, "values before final pivot index should be less then pivot"));
        }
        for (int i = idx + 1; i < array.length; i++) {
            int ge = i;
            tests.add(() -> assertTrue(pivot <= array[ge], "values after final pivot index should be greater then pivot"));
        }
        assertAll(tests);
    }

    @Test
    void arrayCorrectlyArrangedAroundPivot2() {
        int[] array = new int[]{1, 2, 3, 2, 1, 3, 2, 1, 3};
        int idx = HoarePartition.hoarePartition(array, 0, 8, 6);
        List<Executable> tests = new ArrayList<>();
        for (int i = 0; i < idx; i++) {
            int le = i;
            tests.add(() -> assertTrue(array[le] <= array[idx], "values before final pivot index should be less or equal then pivot"));
        }
        for (int i = idx + 1; i < array.length; i++) {
            int ge = i;
            tests.add(() -> assertTrue(array[idx] <= array[ge], "values after final pivot index should be greater or equal then pivot"));
        }
        tests.add(() -> assertEquals(2, array[idx], "final pivot index should contain 5"));
        assertAll(tests);
    }
}