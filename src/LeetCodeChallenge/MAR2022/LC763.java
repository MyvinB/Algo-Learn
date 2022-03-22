package LeetCodeChallenge.MAR2022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 10:12 PM 3/21/2022
 * Time Taken:
 */
public class LC763 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];
        for(int i =0;i<s.length();i++){
            map[s.charAt(i)-'a'] = i;
        }
        int first = 0;
        int last = 0;
        for(int i=0;i<s.length();i++){
            last = Math.max(last,map[s.charAt(i)-'a']);
            if(i==last){
                res.add(last-first +1);
                first = last+1;
            }
        }
        return res;
    }
}
