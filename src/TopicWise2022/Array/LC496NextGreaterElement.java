package TopicWise2022.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
public class LC496NextGreaterElement {
    public static void main(String[] args) {
        int[] t = new int[]{1,3,4,2};
        int [] p = new int[]{4,1,2};
        System.out.println(nextGreaterElement(p,t));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n2 = nums2.length;
        int n1 = nums1.length;
        int[] res = new int[n1];
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=n2-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<nums2[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) map.put(nums2[i],stack.peek());
            stack.push(nums2[i]);
        }
        Arrays.fill(res,-1);
        for(int i=0;i<n1;i++){
            if(map.containsKey(nums1[i])){
                res[i] = map.get(nums1[i]);
            }
        }
        return res;
    }
}
