package LeetCode.String;/*
 @author Myvin Barboza
 03/08/20 3:28 PM 
 */

public class LC125ValidPalindrome {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^a-zA-Z0-9]", "");

        int start=0;
        int end=s.length()-1;
        s=s.toLowerCase();
        while(start<end){

            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }
            else
                return false;
        }
        return true;

    }


}
