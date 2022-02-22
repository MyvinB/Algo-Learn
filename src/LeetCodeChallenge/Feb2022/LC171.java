package LeetCodeChallenge.Feb2022;

/**
 * @author mmichaelbarboza
 * on 6:20 AM 2/22/2022
 * Time Taken:
 */
public class LC171 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
           sum *= 26;
           sum += s.charAt(i)-'A'+1;
        }
        return sum;
    }
}
