package LeetCode.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 @author Myvin Barboza
 13/04/20 6:58 PM 
 */
public class AddtoArrayFormofIntegerLC989 {

    static List<Integer> addToArrayForm(int[] A, int K) {
        String s=String.valueOf(K);
        List<Integer> list=new ArrayList<>();
        int sum=0;
        int carry=0;
        int j=s.length()-1;
        int i=A.length-1;
       while(true){
           if(i<0 && j<0) break;
           sum=(i>=0? A[i]:0) + (j>=0? s.charAt(j)-'0':0) +carry;
           list.add(sum%10);
           carry=sum/10;
           j--;
           i--;
       }


        if(carry!=0) list.add(carry);



        Collections.reverse(list);
        return list;

    }


    public static void main(String[] args) {
        int k=23;
        int nums[]={0};
        System.out.println(addToArrayForm(nums,k));
    }
}