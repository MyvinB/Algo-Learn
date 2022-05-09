package LeetCodeChallenge.MAY2022;

import java.util.ArrayList;
import java.util.List;

public class LC17 {

    public List<String> letterCombinations(String digits) {
        String[] s = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return res;
        dfs(s,digits,"",0,res);
        return res;
    }

    public void dfs(String[] map,String digits,String prefix,int index,List<String> res){
        if(index==digits.length()){
            res.add(prefix);
            return;
        }
        int num = Character.getNumericValue(digits.charAt(index));
        String letters = map[num];
        for(int i=0;i<letters.length();i++){
            dfs(map,digits,prefix+letters.charAt(i),index+1,res);
        }
    }

    public static void main(String[] args) {

    }

}
