package Company.MorganStanley;

/**
 * @author mmichaelbarboza
 * on 8:32 AM 2/22/2022
 * Time Taken:
 */
public class LC7 {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }


    public static int reverse(int x) {
        int sum = 0;
        int newSum = 0;
        while(x!=0){
            int tail = x%10;
            newSum  = sum*10+tail;
            if((newSum-tail)/10 !=sum){
                return 0;
            }
            sum = newSum;
            x = x/10;

        }
        return sum;
    }
}
