package LeetCodeChallenge.JUNE2021;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TimePass {

    public static void main(String[] args) {
//        int[] ranks = new int[]{10,10,2,12,9};
//        char[] suits = new char[]{'a',};
//        int[] t = new int[]{2,10,2019};
////        System.out.println(bestHand(ranks,suits));
//        System.out.println(zeroFilledSubarray(t));
////        NumberContainers p = new NumberContainers();
//        p.find(10);
//        p.change(2,10);
//        p.change(1,10);
//        p.change(3,10);
//        p.change(5,10);
//        p.find(10);
    }

    public static String bestHand(int[] ranks, char[] suits) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<suits.length;i++){
            map.put(suits[i],map.getOrDefault(suits[i],0)+1);
        }
        for(int i:map.values()){
            if(i>=5) return "Flush";
        }
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for(int i=0;i<ranks.length;i++){
            map1.put(ranks[i],map1.getOrDefault(ranks[i],0)+1);
        }
        for(int i:map1.values()){
            if(i>=3) return "Three of a Kind";
        }

        for(int i:map1.values()){
            if(i>=2) return "Pair";
        }
        return "";
    }


    public static long zeroFilledSubarray(int[] nums) {
        int j = 0;
        long total = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                j=i;
                while( j<nums.length && nums[j]==0)j++;
                int count = j-i;
                total+= sumOfN((long)count);
                i=j;
            }
        }
        return total;
    }

    public static long sumOfN(long n){
        return (n *(n+1))/2;
    }

     class NumberContainers {

        class Number{
            int num;
            int belongsTo;
            Number(int num,int belongsTo){
                this.num = num;
                this.belongsTo = belongsTo;
            }
        }
        HashMap<Integer, PriorityQueue<Integer>> map;
        HashMap<Integer,Number> mapNum;
        public NumberContainers() {
            map = new HashMap<>();
            mapNum = new HashMap<>();

        }

        public void change(int index, int number) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            if(map.containsKey(number)){
                   pq = map.get(number);
            }
            Number t = new Number(index,number);
            mapNum.put(index,t);
            pq.offer(index);
            map.put(number,pq);
        }

        public int find(int number) {
            if(!map.containsKey(number)) return -1;
            PriorityQueue<Integer> pq = map.get(number);
            while(!pq.isEmpty()){
                int index = pq.peek();
                if(mapNum.containsKey(index)){
                    Number temp = mapNum.get(index);
                    if(temp.belongsTo == number) return index;
                    else pq.poll();
                }
            }
            return -1;
        }
    }
}
