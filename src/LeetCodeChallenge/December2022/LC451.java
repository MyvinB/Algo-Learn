package LeetCodeChallenge.December2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC451 {

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s) {
        int[] t = new int[128];
        int n = s.length();
        List<Character> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(t[s.charAt(i)]==0) list.add(s.charAt(i));
            t[s.charAt(i)]++;
        }
        System.out.println(Arrays.toString(t));
        Collections.sort(list,(a,b)->{
            return t[b]-t[a];
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++) {
            int count = t[list.get(i)];
            while(count--!=0)
                sb.append(list.get(i));
        }
        return sb.toString();
    }
}
