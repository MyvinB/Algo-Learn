package LeetCodeChallenge.MAR2022;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 7:43 AM 3/22/2022
 * Time Taken:
 */
public class LC1663 {

    public static void main(String[] args) {
        System.out.println('z'-'a');
    }

    public String getSmallestString(int n, int k) {
        char res[] = new char[n];
        Arrays.fill(res,'a');
        k -=n;
        while(k>0){
            res[--n] += (char) Math.min(25,k);
            k -= Math.min(25,k);
        }
        return String.valueOf(res);
    }
}
