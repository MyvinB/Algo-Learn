package practise;

import java.util.HashMap;
import java.util.Stack;

public class LC496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int num:nums2){
            while(!stack.isEmpty() && stack.peek()<num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }

        for(int i=0;i<nums1.length;i++){
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}
