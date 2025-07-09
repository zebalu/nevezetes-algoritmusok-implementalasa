package io.github.zebalu.nai.feladat01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.util.Random;
import java.util.random.RandomGenerator;

import static org.junit.jupiter.api.Assertions.*;

class MedianFinderTest {

    @Test
    void findMedian() {
        int[] array = {1,2,3,4,5,6,7,8,9};
        assertEquals(5, MedianFinder.medianOfMedians(array));
    }

    @Test
    void findMedian2() {
        RandomGenerator eg = new Random(1234);
        int[] array = new int[626];
        for(int i = 0; i < array.length; i++) {
            array[i] = eg.nextInt(1000)+1;
        }
        assertEquals(472, MedianFinder.medianOfMedians(array));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "RUN_BIG_TESTS", matches = "true")
    void findMedianLarge() {
        RandomGenerator eg = new Random(1234);
        int[] array = new int[300_000_000];
        for(int i = 0; i < array.length; i++) {
            array[i] = eg.nextInt(1_000_000)+1;
        }
        assertEquals(499971, MedianFinder.medianOfMedians(array));
    }
}