package io.github.zebalu.nai.feladat01;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MedianChainTest {

    @Test
    void emptyThrowsException() {
        MedianChain mc = new MedianChain();
        assertThrows(NoSuchElementException.class, mc::getMedian);
    }

    @Test
    void oneValueIsTheMedian() {
        MedianChain mc = new MedianChain();
        mc.addValue(1);
        assertEquals(1, mc.getMedian());
    }

    @Test
    void fromTwoValueSmallerIsMedian() {
        MedianChain mc = new MedianChain();
        mc.addValue(2);
        mc.addValue(1);
        assertEquals(1, mc.getMedian());
    }

    @Test
    void fromThreeValueMiddleIsMedian() {
        MedianChain mc = new MedianChain();
        mc.addValue(2);
        mc.addValue(1);
        mc.addValue(3);
        assertEquals(2, mc.getMedian());
    }

    @Test
    void exactlyMagicNumberValuesWork() {
        MedianChain mc = new MedianChain();
        for(int i=0; i<5; ++i) {
            mc.addValue(i+1);
        }
        assertEquals(3, mc.getMedian());
    }
}