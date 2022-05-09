package LeetCodeChallenge.MAY2022;

import java.util.LinkedList;
import java.util.Queue;

public class LC225 {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=4;i++)
            queue.add(i);
        int size = queue.size()-1;
        while(size-->0){
            queue.add(queue.poll());
        }
        System.out.println(queue);
    }

    class MyStack {
        Queue<Integer> queue;
        public MyStack() {
            queue = new LinkedList<>();
        }
        public void push(int x) {
            queue.offer(x);
            int size = queue.size()-1;
            while(size-->0){
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }


}
