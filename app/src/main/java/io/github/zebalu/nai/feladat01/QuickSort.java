package io.github.zebalu.nai.feladat01;

import java.util.ArrayDeque;
import java.util.Queue;

final class QuickSort {
    private QuickSort() {
        throw new IllegalAccessError("Utility Class");
    }

    static void quickSort(int[] array) {
        record Triplet(int from, int to, int pidx) {
            int size() {
                return to-from+1;
            }
        }
        Queue<Triplet> queue = new ArrayDeque<>();
        queue.add(new Triplet(0, array.length - 1, array.length /2));
        while (!queue.isEmpty()) {
            Triplet triplet = queue.poll();
            if(triplet.size()>1) {
                int partition = HoarePartition.hoarePartition(array, triplet.from, triplet.to, triplet.pidx);
                if(triplet.size()>2) {
                    queue.add(new Triplet(triplet.from, partition-1, triplet.from));
                    queue.add(new Triplet(partition, triplet.to, triplet.to));
                }
            }
        }
    }
}
