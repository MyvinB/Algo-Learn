package TopicWise2022.Array;

import java.util.Arrays;

public class LC179LargestNumber {

    public static void main(String[] args) {
        int[] t = new int[]{3,30,34,5,9};
        System.out.println("1".compareTo("2"));
        largestNumber(t);
    }

    public static String largestNumber(int[] nums) {
        if(nums==null ||nums.length==0) return "";
        int n = nums.length;
        String[] strs = new String[n];
        for(int i=0;i<nums.length;i++){
            strs[i] = nums[i]+"";
        }
        Arrays.sort(strs,(a,b)->{
            String p = a+b;
            String q = b+a;
            return q.compareTo(p);
        });
        StringBuilder sb = new StringBuilder();
        if(strs[0].equals("0")) return "0";
        for(int i=0;i<n;i++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
