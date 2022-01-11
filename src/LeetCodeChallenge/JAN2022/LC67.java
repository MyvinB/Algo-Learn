package LeetCodeChallenge.JAN2022;

/**
 * @author mmichaelbarboza
 * on 7:30 AM 1/10/2022
 */
public class LC67 {
    public static void main(String[] args) {
        System.out.println(addBinary("11","11"));

    }

    public static String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int m = a.length()-1;
    int n = b.length()-1;
    int carry = 0;
    int sum = 0;
    int no1 =0;
    int no2 = 0;
    while(true){
        if(m<0 && n<0) break;
        no1 = m>=0?a.charAt(m)-'0':0;
        no2 = n>=0?b.charAt(n)-'0':0;
        sum= no1+no2+carry;
        sb.append(sum%2);
        carry = sum/2;
        m--;n--;
    }
    if(carry!=0) sb.append(carry);
    return sb.reverse().toString();
    }
}
