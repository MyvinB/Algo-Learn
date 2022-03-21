package LeetCodeChallenge.MAR2022;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 9:41 AM 3/19/2022
 * Time Taken:
 */
public class LC895 {
    ///Work with stack just keep each freq stack //simple
    class FreqStack {
        HashMap<Integer,Integer> freq;
        HashMap<Integer, Stack<Integer>> map;
        int maxFreq;
        public FreqStack() {
            map = new HashMap<>();
            freq = new HashMap<>();
        }

        public void push(int val) {
            //Update the freq map
            Integer f = freq.getOrDefault(val,0)+1;
            freq.put(val ,f);
            maxFreq = Math.max(maxFreq,f);
            if(!map.containsKey(f)) map.put(f,new Stack<>());
            map.get(f).add(val);
        }
        public int pop() {
            Integer pop = map.get(maxFreq).pop();
            freq.put(pop,maxFreq-1);
            if(map.get(maxFreq).size() == 0) maxFreq --;
            return pop;
        }
    }

    class FreqStackUsingPQ{
        PriorityQueue<int[]> pq;
        int index = 0;
        HashMap<Integer,Integer> freq;
        public void FreqStack() {
            freq = new HashMap<>();
            //if freq is same then you check index
            pq = new PriorityQueue<>((a,b)->a[1]!=b[1]?b[1]-a[1]:b[2]-a[2]);
        }

        public void push(int val) {
            int f = freq.getOrDefault(val,0)+1;
            freq.put(val,f);
            pq.offer(new int[]{val,freq.get(val),index++});
        }

        public int pop() {
            int pop = pq.poll()[0];
            freq.put(pop,freq.get(pop)-1);
            if(freq.get(pop)==0) freq.remove(pop);
            return pop;
        }
    }
}
