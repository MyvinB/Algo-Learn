package LeetCodeChallenge.MAY2022;

public class LC341 {
    public static void main(String[] args) {

    }

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return empty list if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */

/*
Uses memory optimisation does not extract to the stack until we use next;

    public class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            prepareStack(nestedList);
        }

        private void prepareStack(List<NestedInteger> nestedList){
            for(int i=nestedList.size()-1;i>=0;i--){
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            if(!hasNext()){
                return null;
            }
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while(!stack.isEmpty() && !stack.peek().isInteger()){
                prepareStack(stack.pop().getList());
            }

            return !stack.isEmpty();
        }
    }

 */
/**

 Using list
 /**
 * This is the smartest one and easiest of them all.
 * We basically process the given list and store all the values;
 * <p>
 * Advantages:
 * 1. Its fast
 * 2. this is fail safe iterator, means it won't throw concurrent modification exception
 * 3. good choice for multi threading
 * <p>
 * Disadvantages:
 * 1. This occupy lot of extra space, and
 * 2. this is not lazy in its behaviour rather proactive
 public class NestedIterator implements Iterator<Integer> {

 private List<Integer> flist = null;
 private Iterator<Integer> itr = null;

 public NestedIterator(List<NestedInteger> nestedList) {
 flist = new ArrayList<>();
 flatten(nestedList);
 itr = flist.iterator();
 }

 private void flatten(List<NestedInteger> nestedList){
 for(NestedInteger cur:nestedList){
 if(cur.isInteger()) flist.add(cur.getInteger());
 else flatten(cur.getList());
 }
 }

 @Override
 public Integer next() {
 if(itr.hasNext()) return itr.next();
 return null;
 }

 @Override
 public boolean hasNext() {
 return itr.hasNext();
 }
 }
 /

 /**
  * Your NestedIterator object will be instantiated and called as such:
  * NestedIterator i = new NestedIterator(nestedList);
  * while (i.hasNext()) v[f()] = i.next();
 */

}
