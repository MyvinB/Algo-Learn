package LeetCode.BitWiseAlgo;/*
 @author Myvin Barboza
 23/07/20 4:38 PM
 help:https://www.youtube.com/watch?v=XAmaiztzDiQ
 */

public class LC260SingleNumberIII {

    public static void main(String[] args) {

    }

    public int[] singleNumber(int[] nums) {
        int temp=0;
        //gives you the sum of the two single numbers
        for(int i=0;i<nums.length;i++){
            temp=temp^nums[i];
        }


        //consider it giving you a bit such that that bit is 0 in one number and
        //1 in another
        int mask=temp&-temp;
        int first=0;
        //getting the first number
        for(int a:nums){
            if((a&mask)==0)
                first=first^a;
        }
        //simple xor from the total sum will give the second
        return new int[]{first,first^temp};
    }
}


