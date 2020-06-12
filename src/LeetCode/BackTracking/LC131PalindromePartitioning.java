package LeetCode.BackTracking;
/*
 @author Myvin Barboza
 11/06/20 2:45 PM 
 */

import java.util.ArrayList;
import java.util.List;

public class LC131PalindromePartitioning {

     static List<List<String>> partition(String s) {
         List<List<String>> list=new ArrayList<>();
        partition(new ArrayList<>(),list,0,s);
        return list;
    }

    static void partition(List<String> res,List<List<String>> list,int index,String s){
        if(index==s.length()) list.add(new ArrayList<>(res));
        else{
            for (int i = index; i <s.length() ; i++) {
                if(isPalindrome(index,i,s)){
                    String snippet=s.substring(index,i+1);
                    res.add(snippet);
                    partition(res,list,i+1,s);
                    res.remove(res.size()-1);
                }
            }

        }
    }


    static boolean isPalindrome(int low,int high,String s){
        while(low<high){
            if(s.charAt(low)!=s.charAt(high))return false;
        low++;high--;
        }
        return true;
    }

//no string and the complete string is considered as one palindrome
    public static void main(String[] args) {
        String s="aabaa";
      ///  System.out.println(isPalindrome(0,4,"aabaa"));
        System.out.println(partition(s));
    }
}