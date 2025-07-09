package io.github.zebalu.nai.feladat01;

final class MedianFinder {
    private MedianFinder() {
        throw new IllegalAccessError("utility class");
    }

    static int medianOfMedians(int[] array) {
        int from = 0;
        int to = array.length - 1;
        int expectedIdx = (array.length - 1) / 2;
        int currentIdx = -1;
        while (currentIdx != expectedIdx) {
            MedianChain mc = new MedianChain();
            for (int i = from; i <= to; i++) {
                mc.addValue(array[i]);
            }
            int vIdx = mc.getMedianIndex() + from;
            currentIdx = LumotoPartition.lumotoPartition(array, from, to, vIdx);
            if (currentIdx < expectedIdx) {
                from = currentIdx + 1;
            } else if (currentIdx > expectedIdx) {
                to = currentIdx - 1;
            }
        }
        return array[currentIdx];
    }

}
