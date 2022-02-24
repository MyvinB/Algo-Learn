package Company.MorganStanley;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 8:48 AM 2/24/2022
 * Time Taken:
 */
public class LC17 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        //iteratvie
        LinkedList<String> queue = new LinkedList<>();
        if(digits.isEmpty()) return queue;
        String[] s = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        queue.add("");
        for(int i=0;i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(queue.peek().length()==i){
                String prev = queue.poll();
                for(char t: s[x].toCharArray()){
                    queue.offer(prev+t);
                }
            }
        }
        return queue;
    }



    public static List<String> letterCombinationsDfs(String digits) {
        String[] s = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        dfs(digits,s,"",0,res);
        return res;
    }

    public static void dfs(String digits,String[] map,String prefix,int index,List<String> res){
        //Terminal Conditions
        if(index>=digits.length()){
            res.add(prefix);
            return;
        }
        int num = Character.getNumericValue(digits.charAt(index));
        String letters = map[num];
        for(int i=0;i<letters.length();i++){
            dfs(digits,map,prefix+letters.charAt(i),index+1,res);
        }
    }

}
