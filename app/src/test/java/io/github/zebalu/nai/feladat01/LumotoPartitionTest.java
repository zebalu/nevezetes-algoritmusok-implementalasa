package io.github.zebalu.nai.feladat01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LumotoPartitionTest {

    @Test
    void partitionReturnsCorrectPivotPosition() {
        int[] array = {4, 9, 5, 3, 2, 6, 1, 7, 8};
        int pivotIndex = LumotoPartition.lumotoPartition(array, 0, 8, 2);
        List<Executable> toAssert = new ArrayList<>();
        for (int i = 0; i < pivotIndex; ++i) {
            int ii = i;
            toAssert.add(() -> assertTrue(array[ii] < array[pivotIndex]));
        }
        toAssert.add(() -> assertEquals(5, array[pivotIndex]));
        for (int i = pivotIndex + 1; i < array.length; ++i) {
            int ii = i;
            toAssert.add(() -> assertTrue(array[pivotIndex] <= array[ii]));
        }
        assertAll(toAssert);
    }

    @Test
    void partitionHandlesDuplicates() {
        int[] array = {1, 2, 3, 3, 2, 1, 1, 3, 2};
        int pivotIndex = LumotoPartition.lumotoPartition(array, 0, 8, 4);
        assertEquals(2, array[pivotIndex]);
    }

}