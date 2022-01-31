package LeetCodeChallenge.JAN2022.practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mmichaelbarboza
 * on 8:34 AM 1/30/2022
 */
public class Contest302022 {

    public static void main(String[] args) {
        int[] t = new int[] {
                5,3,6,1,12
        };
//        System.out.println(findFinalValue(t,3));
//        int[] t2 = new int[] {
//                1,1
//        };
//        System.out.println(maxScoreIndices(t2));
        System.out.println(subStrHash("xmmhdakfursinye",
                96,
                45,
                15,
                21));
    }
    //To easy
    public static int findFinalValue(int[] nums, int original) {
        int n=nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        while(set.contains(original)){
            original= original*2;
        }
        return original;

    }

    //Naive code need to use presum
    public static List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        int leftZero[] = new int[n + 1];
        int rightZero[] = new int[n + 1];
        int count = 0;
        for (int i = 0; i <= n; i++) {
            leftZero[i] = count;
            if (i < n && nums[i] == 0) {
                count++;
            }
        }
        //reset counter
        count = 0;
        for (int i = n; i >= 0; i--) {
            if (i != n && nums[i] == 1) {
                count++;
            }
            rightZero[i] = count;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, leftZero[i] + rightZero[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (max == leftZero[i] + rightZero[i]) res.add(i);
        }
        return res;


    }

    //Failure naive code not working possibly over flow using rolling hash LC2156
    public static String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum=0;
            int count=0;
            for(int j=i;j<s.length() && j<i+k;j++){

                sum += ((s.charAt(j)-'a')+1) * Math.pow(power,count++);
//                System.out.println(((s.charAt(i)-'a')+1) * Math.pow(power,count));
            }
            sum = sum % modulo;
            if(hashValue==sum){
                return s.substring(i,i+k);
            };
        }
        return "";
    }
}
