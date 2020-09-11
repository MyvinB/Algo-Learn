package LeetCode.Array;

public class LC299BullsAndCows {
    public static void main(String[] args) {
        String secret = "1807",guess = "7810";
        System.out.println(getHint(secret,guess));

    }
    static  String getHint(String secret, String guess) {
        int[] count = new int[10];
        int bulls =0;
        int cow = 0;
        for (int i = 0; i <secret.length(); i++) {
            if(secret.charAt(i)==guess.charAt(i))bulls++;
            else{
                if(count[secret.charAt(i)-'0']++<0)cow++;
                if(count[guess.charAt(i)-'0']-->0)cow++;
            }
        }
        return bulls+"A"+cow+"B";

    }
}
