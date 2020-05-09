package LeetCode.BitWiseAlgo;

/*
 @author Myvin Barboza
 13/04/20 5:56 PM 
 */
public class AddBinaryLC67 {

    static String addBinary(String a, String b) {
    int m=a.length()-1;
    int n=b.length()-1;
    int carry=0;
    int sum=0;

    StringBuffer sb=new StringBuffer();
    while(true) {
        if(m<0 && n<0) break;
        int no1=m>=0?a.charAt(m)-'0':0;
        int no2=n>=0?b.charAt(n)-'0':0;
        sum=no1+no2+carry;
        m--;
        n--;
        sb.append(sum%2);
        carry=sum/2;
    }
    if(carry!=0)sb.append(carry);

    return sb.reverse().toString();


    }


    public static void main(String[] args) {
        System.out.println(addBinary("1111","1111"));
    }
}