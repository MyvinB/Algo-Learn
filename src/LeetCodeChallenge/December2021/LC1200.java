package LeetCodeChallenge.December2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 1:53 PM 12/20/2021
 */
public class LC1200 {

    public static void main(String[] args) {
        int[] a ={4,2,1,3};
        int[] b = {1,3,6,10,15};
        int[] c = {3,8,-10,23,19,-4,-14,27};
        System.out.println(minimumAbsDifference(c));
    }

    public static  List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<n;i++){
            min = Math.min(min,arr[i]-arr[i-1]);
        }
        int diff = 0;
        for(int i=1;i<n;i++){
            diff = arr[i]- arr[i-1];
            if(diff == min){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                res.add(new ArrayList<>(temp));
            }
        }
        return res;
    }
}
