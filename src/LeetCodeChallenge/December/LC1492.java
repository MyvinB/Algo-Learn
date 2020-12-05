package LeetCodeChallenge.December;/*
 @author Myvin Barboza
 05/12/20 12:34 PM 
 */

public class LC1492 {
    public int kthFactor(int n, int k) {
        for(int i=1;i<=n;i++){
            if(n%i == 0){
                k--;
            }
            if(k==0)
                return i;
        }
        return -1;
    }


}
