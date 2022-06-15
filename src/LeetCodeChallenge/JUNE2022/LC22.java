package LeetCodeChallenge.JUNE2022;

import java.util.ArrayList;
import java.util.List;

public class LC22 {

    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res,"",0,0,n);
        return res;
    }

    public void backTrack(List<String> res,String cur,int open,int close,int max){
        if(cur.length()==max*2){
            res.add(cur);
            return;
        }
        if(open<max){
            backTrack(res,cur+"(",open+1,close,max);
        }
        if(close<open){
            backTrack(res,cur+")",open,close+1,max);
        }
    }
}
