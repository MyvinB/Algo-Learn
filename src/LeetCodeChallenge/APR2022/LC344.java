package LeetCodeChallenge.APR2022;

/**
 * @author mmichaelbarboza
 * on 10:22 AM 4/1/2022
 * Time Taken:
 */
public class LC344 {

    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int low = 0;
        int high = s.length-1;
        while(low<high){
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }

    }
}
