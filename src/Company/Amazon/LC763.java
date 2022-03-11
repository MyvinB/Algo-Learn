package Company.Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 11:10 AM 3/11/2022
 * Time Taken:
 */
public class LC763 {

    public static void main(String[] args) {

    }

    public List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        for(int i=0;i<S.length();i++){
            map[S.charAt(i)-'a']=i;
        }
        int last = 0;
        int first =0;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<S.length();i++){
            last = Math.max(last,map[S.charAt(i)-'a']);
            if(i==last){
                res.add(last-first+1);
                first = last+1;
            }
        }
        return res;
    }
}
