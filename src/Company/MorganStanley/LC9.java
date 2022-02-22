package Company.MorganStanley;

/**
 * @author mmichaelbarboza
 * on 8:23 AM 2/22/2022
 * Time Taken:
 */
public class LC9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        int temp = x;
        int sum = 0;
        if(x<0) return false;
        while(temp!=0){
            sum = sum*10+ temp%10;
            temp = temp/10;
        }
        return x==sum;
    }
}
