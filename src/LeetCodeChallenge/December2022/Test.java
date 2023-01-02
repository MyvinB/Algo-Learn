package LeetCodeChallenge.December2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        int[] t = new int[]{10,40,20};
        //Assuming no duplicates
        HashMap<Integer,Integer> map = new HashMap<>();
        //if there are duplicate take a map like this and keep adding to the list when same element is there
        //when you find the element then empty the entire list with duplicates there can be multiple answers
        HashMap<Integer,List<Integer>> mapDuplicates = new HashMap<>();
        for(int i=0;i<t.length;i++) map.put(t[i],i);
        Arrays.sort(t);
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<t.length;i++){
            res.add(map.get(t[i]));
        }
        System.out.println(res);
        String s = "FB";
        String p ="Ea";
        System.out.println(s.hashCode());
        System.out.println(p.hashCode());
        System.out.println(s.hashCode()==p.hashCode());
        System.out.println(s==p);
    }
}
