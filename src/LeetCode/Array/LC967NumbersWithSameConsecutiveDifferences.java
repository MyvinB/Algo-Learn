package LeetCode.Array;/*
 @author Myvin Barboza
 18/08/20 5:48 PM 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC967NumbersWithSameConsecutiveDifferences {
    static List<Integer> numsSameConsecDiff(int N, int k) {
        List<Integer> cur= Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        for(int i=2;i<=N;i++){
            List<Integer> cur2=new ArrayList<>();
            for(int x:cur){
                int y=x%10;
                if(x>0 && y+k<10){
                    cur2.add(x*10+y+k);
                }
                if(x>0 && k>0 && y-k>=0){
                    cur2.add(x*10+y-k);
                }
            }
            cur=cur2;

        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(numsSameConsecDiff(2,7));
    }

}
