package LeetCodeChallenge.JAN2022.practise;

import java.util.Iterator;

/**
 * @author mmichaelbarboza
 * on 9:58 AM 1/27/2022
 */
public class LC284 {

    public static void main(String[] args) {

    }

    class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> iter;
        boolean noSuchElement;
        Integer next;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            iter=iterator;
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
            return !noSuchElement;
        }

        private void advanceIter(){
            if(iter.hasNext()){
                next = iter.next();
            }else {
                noSuchElement = true;
            }
        }
    }
}
