package LeetCodeChallenge.Feb2022;

/**
 * @author mmichaelbarboza
 * on 7:23 AM 2/8/2022
 * Time Taken:
 */
public class LC258 {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {
        int res =0;
        do{
            res=0;
            while(num!=0){
                res += num%10;
                num=num/10;
            }
            num=res;
        }while(res>9);

      return res;
    }
}
