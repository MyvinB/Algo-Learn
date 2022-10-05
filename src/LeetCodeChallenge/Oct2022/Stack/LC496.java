package LeetCodeChallenge.Oct2022.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LC496 {


    public static void main(String[] args) {

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<nums2[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) map.put(nums2[i],stack.peek());

            stack.push(nums2[i]);
        }
        int n = nums1.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<n;i++){
            if(map.containsKey(nums1[i])){
                res[i] = map.get(nums1[i]);
            }
        }
        return res;
    }
}
