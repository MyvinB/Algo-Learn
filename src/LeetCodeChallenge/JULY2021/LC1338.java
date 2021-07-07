package LeetCodeChallenge.JULY2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LC1338 {
    public static void main(String[] args) {
        System.out.println(minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
    }


    public static int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i <n ; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        System.out.println(map);
        List<Integer> freq = new ArrayList<>(map.values());
        freq.sort(Collections.reverseOrder());
        int total = n;
        int i=0;
        while(total>n/2){
            total -= freq.get(i);
            i++;
        }
        return i;
    }
}
