package LeetCodeChallenge.APR2022;

import java.util.Iterator;

/**
 * @author mmichaelbarboza
 * on 1:43 PM 4/25/2022
 * Time Taken:
 */
public class LC284PeekingIterator {

    class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> iter;
        Integer  next;
        boolean noNextElement;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            iter = iterator;
            advanceIter();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer res = next;
            advanceIter();
            return res;
        }

        @Override
        public boolean hasNext() {
            return !noNextElement;
        }

        void advanceIter(){
            if(iter.hasNext()){
                next = iter.next();
            }
            else noNextElement = true;
        }
    }
}
