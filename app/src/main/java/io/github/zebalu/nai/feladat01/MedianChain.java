package io.github.zebalu.nai.feladat01;

import java.util.*;

class MedianChain {
    private static final int MAGIC_NUMBER = 5;
    private final List<List<Pair>> chain = new ArrayList<>();
    private int index = 0;
    private Pair median = null;

    public void addValue(int value) {
        if(median != null) {
            throw new IllegalStateException("This MedianChain is already processed");
        }
        pushValue(toPair(value), 0);
    }

    public int getMedian() {
        calculateFinalMedian();
        return median.value();
    }

    public int getMedianIndex() {
        calculateFinalMedian();
        return median.index();
    }

    private void calculateFinalMedian() {
        if(median != null) {
            return;
        }
        if(chain.isEmpty()) {
            throw new NoSuchElementException("Empty median chain");
        }
        while (!chain.isEmpty()) {
            List<Pair> top = chain.removeFirst();
            if(!top.isEmpty()) {
                Pair median = getMedian(top);
                if(chain.isEmpty()) {
                    this.median = median;
                } else {
                    pushValue(median, 0);
                }
            }
        }
    }

    private Pair toPair(int value) {
        Pair pair = new Pair(value, index);
        ++index;
        return pair;
    }

    private void pushValue(Pair value, int level) {
        List<Pair> list = getLevel(level);
        list.add(value);
        if(list.size()==MAGIC_NUMBER) {
            Pair median = getMedian(list);
            pushValue(median, level+1);
            list.clear();
        }
    }

    private List<Pair> getLevel(int level) {
        while(chain.size() <= level) {
            chain.add( new ArrayList<>());
        }
        return chain.get(level);
    }

    private Pair getMedian(List<Pair> list) {
        if(list.isEmpty()) {
            throw new NoSuchElementException("Empty list has no median");
        }
        Collections.sort(list);
        return list.get((list.size()-1)/2);
    }

    private record Pair(int value, int index) implements Comparable<Pair> {
        private static final Comparator<Pair> VALUE_COMPARATOR = Comparator.comparingInt(Pair::value);

        @Override
        public int compareTo(Pair o) {
            return VALUE_COMPARATOR.compare(this, o);
        }
    }
}
