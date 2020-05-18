package LeetCode.Combinatorics;
/*
 @author Myvin Barboza
 18/05/20 8:37 AM 
 */

import java.util.LinkedList;
import java.util.List;

public class LC60PermutationSequence {

    static String getPermutation(int n, int k) {
        List<Integer> num=new LinkedList<>();
        //making it a one based index
        int fact[]=new int[n];
        fact[0]=1;
        for (int i = 1; i <n ; i++) {
        num.add(i);
        fact[i]=fact[i-1]*i;
        }
        //dont really require the last fact say 1234 we cal 3! at start
        num.add(n);
        //Account that k is starting from zero
        k--;
        // starting from zero index so even while calculating indx
        // in this way we are taking one less always 13% 6 giving us  and indx=2  k=1 will give us the right permutation index
        //instead of 14%6 giving us index2 but then then k =1 wont give it
        StringBuilder sb=new StringBuilder();
        for(int i=n;i>0;i--){
            int index=k/fact[i-1];
            k=k%fact[i-1];
            sb.append(num.get(index));
            num.remove(index);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4,14));
    }
}