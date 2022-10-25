package LeetCodeChallenge.Oct2022.Daily;

import java.util.List;

public class LC1239 {

    public static void main(String[] args) {
        String[] ar = new String[]{"abcdefghijklmnopqrstuvwxyz"};
        System.out.println(maxLength(List.of(ar)));
    }

    public static int maxLength(List<String> arr) {
        int n = arr.size();
        return recur(arr,0,"");
    }

    public static int recur(List<String> arr,int idx,String prev){
        if(idx == arr.size()) return prev.length();
        //We cannot take the current element is one choice based on decision point
        //We take or not take the element based on decision point
        int max = Integer.MIN_VALUE;
        String cur = arr.get(idx)+prev;
        int[] a = new int[26];
        for(int i=0;i<cur.length();i++){
            if(a[cur.charAt(i)-'a']!=0) {
                return recur(arr,idx+1,prev);
            }
            a[cur.charAt(i)-'a']++;
        }
        int take = recur(arr,idx+1,cur);
        int noTake = recur(arr,idx+1,prev);
        return Math.max(take,noTake);
    }

}
