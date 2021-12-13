package LeetCodeChallenge.December2021;

/**
 * @author mmichaelbarboza
 * on 12:55 PM 12/13/2021
 */
public class LC1446 {
    public static void main(String[] args) {
        String s = "abbcccddddeeeeedcba";
        System.out.println(maxPower(s));
        System.out.println(maxPowerSlidingWindow(s));
    }

    public static int maxPower(String s) {
        int maxPower=1;
        int count = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }
            else{
                maxPower = Math.max(maxPower,count);
                count =1;
            }
        }
        if(count!=1){
            maxPower = Math.max(maxPower,count);
        }
        return maxPower;
    }

    public static int maxPowerSlidingWindow(String s){
        int maxPower = 1;
        for(int left=0,right=1;right<=s.length();right++){
            if(right==s.length()||s.charAt(left)!=s.charAt(right)){
                maxPower = Math.max(maxPower,right-left);
                left=right;
            }
        }
        return maxPower;
    }
}
