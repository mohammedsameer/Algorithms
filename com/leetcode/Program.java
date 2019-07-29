package com.leetcode;

import java.util.*;

//Algo:
class Program {

    class PeekingIterator implements Iterator<Integer> {

        Iterator<Integer> myIterator;
        Integer next;
        public PeekingIterator(Iterator<Integer> iterator) {
            myIterator = iterator;
            next = myIterator.hasNext() ? myIterator.next() : null;
        }

        public Integer peek() {
            return next;
        }

        public Integer next() {
            Integer result = next;
            next = myIterator.hasNext() ? myIterator.next() : null;
            return result;
        }

        public boolean hasNext() {
            return next!= null;
        }
    }

    public static void main(String[] args) {
    }
}
