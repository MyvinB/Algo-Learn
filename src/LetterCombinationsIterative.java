/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsIterative {
    static List<String> letterCombinations(String digits) {
        List<String> answer=new ArrayList<String>();
        if(digits.equals(""))return answer;
        answer.add("");
        char [][]dp = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        for (int i = 0; i <digits.length() ; i++) {
            char ch=digits.charAt(i);
            ArrayList<String> temp=new ArrayList<String>();
            for(String a:answer){
                for(char c:dp[ch-'0']){
                    temp.add(a+c);
                }
            }
            answer=temp;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("235"));
    }
}
