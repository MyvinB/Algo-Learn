package LeetCodeChallenge.APR2022;

/**
 * @author mmichaelbarboza
 * on 9:10 AM 4/2/2022
 * Time Taken:
 */
public class LC680 {

    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
    }

    public static boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length() -1;
        //"abca"
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)){
                int l1 = low+1;
                int h1 = high;
                int l2 = low;
                int h2 = high-1;
                while(l1<h1 && s.charAt(l1)==s.charAt(h1)){l1++; h1--;}
                while(l2<h2 && s.charAt(l2)==s.charAt(h2)){l2++; h2--;}
                return l1>=h1 || l2>=h2;
            }
            low++;
            high--;
        }
        return true;
    }
}
