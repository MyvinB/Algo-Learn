package LeetCodeChallenge.JULY2021;

import java.util.ArrayList;
import java.util.List;

public class LC89 {
    public static void main(String[] args) {

    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0)
        for (int i = 1; i <= n; i++) {
            int prevLength = res.size();
            //N=N<<2 then N will become N=N*(2^2)
            int mask = 1 << (i - 1);
            for (int j = prevLength - 1; j >= 0; j--){
                res.add(mask+res.get(j));
            }
        }
        return res;
    }
}
