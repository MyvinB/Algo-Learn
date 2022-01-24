package LeetCodeChallenge.JAN2022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 12:08 PM 1/23/2022
 */
public class LC1291 {

    public static void main(String[] args) {
        System.out.println(sequentialDigits(100,300));
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        List<Integer> res = new ArrayList<>();
        for(int i=2;i<=s.length();i++){
            for(int j=0;j+i<=s.length();j++){
                int num = Integer.parseInt(s.substring(j,j+i));
                if(num>= low &&  num<=high) res.add(num);
            }
        }
        return res;
    }



}
