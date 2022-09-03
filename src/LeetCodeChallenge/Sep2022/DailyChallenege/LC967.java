package LeetCodeChallenge.Sep2022.DailyChallenege;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC967 {

    public static void main(String[] args) {

    }

    public int[] numsSameConsecDiff(int N, int k) {
        List<Integer> cur = Arrays.asList(1,2,3,4,5,6,7,8,9);
        for(int i=2;i<=N;i++){
            List<Integer> res = new ArrayList<>();
            for(int x:cur){
                int y = x%10;
                if(y+k<10)
                    res.add(x*10+y+k);
                //K >0 to avoid duplicates
                if(k>0 && y-k>=0)
                    res.add(x*10+y-k);
            }
            cur = res;
        }
        return cur.stream().mapToInt(i->i).toArray();
    }
}
