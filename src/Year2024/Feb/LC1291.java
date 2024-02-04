package Year2024.Feb;

import java.util.*;

public class LC1291 {
    //low = 100 and high = 300 ans = 123,234
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i=1;i<=9;i++){
            int sum = 0;
            for(int j=i;j<=9;j++){
                sum = 10*sum+j;
                if(sum>=low && sum<=high){
                    res.add(sum);
                }
            }
        }
        Collections.sort(res);
        return res;
    }



}
