package LeetCodeChallenge.Sep2022.DailyChallenege;

import java.util.Arrays;

public class LC2007 {

    public static void main(String[] args) {
        int[] t = new int[]{100000,100000};
        System.out.println(Arrays.toString(findOriginalArray(t)));
    }

    public static int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        //if odd return
        if(n%2!=0) return new int[]{};
        int[] res = new int[n/2];
        int[] freq = new int[100001];
        for(int i=0;i<n;i++) freq[changed[i]]++;
        int k= 0;
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                while(freq[i]>0 && i*2<100001){
                    freq[i]--;
                    freq[i*2]--;
                    res[k] = i;  k++;
                    if(freq[i]<0 || freq[i*2]<0) return new int[]{};
                }
                if(i*2>100001) return new int[]{};

            }
        }
        return res;
    }
}
