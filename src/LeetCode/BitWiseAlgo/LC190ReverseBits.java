package LeetCode.BitWiseAlgo;/*
 @author Myvin Barboza
 13/07/20 11:51 AM 
 */

public class LC190ReverseBits {


    public int reverseBits(int n) {
        if(n==0) return 0;
        int res=0;
        for(int i=0;i<32;i++){
            res<<=1;
            if((n&1)==1)res++;
            n>>=1;
        }
        return res;
    }

}
