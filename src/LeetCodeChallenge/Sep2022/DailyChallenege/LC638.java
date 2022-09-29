package LeetCodeChallenge.Sep2022.DailyChallenege;

import java.util.ArrayList;
import java.util.List;

public class LC638 {

    public static void main(String[] args) {

    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0,r=arr.length;
        while(l<r && r-l>=k){
            if(Math.abs(arr[l]-x)>Math.abs(arr[r]-x)){
                l++;
            }else r++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=l;i<=r;i++) res.add(arr[i]);
        return res;
    }
}
