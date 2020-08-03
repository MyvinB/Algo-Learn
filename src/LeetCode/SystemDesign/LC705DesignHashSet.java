package LeetCode.SystemDesign;/*
 @author Myvin Barboza
 03/08/20 11:32 AM 
 */

public class LC705DesignHashSet {
    public static void main(String[] args) {

    }
    class MyHashSet {

        /** Initialize your data structure here. */
        boolean[] a;
        public MyHashSet() {
            a=new boolean[10000001];
        }

        public void add(int key) {
            a[key]=true;
        }

        public void remove(int key) {
            a[key]=false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return a[key];
        }
    }

}
