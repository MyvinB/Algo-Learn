package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 11:13 AM 3/23/2022
 * Time Taken:
 */
public class LC991 {

    public static void main(String[] args) {
        System.out.println(brokenCalc(5,8));
    }

    public static int brokenCalc(int startValue, int target) {
        int result = 0;
        while(target>startValue){
            if(target%2 == 0){
                target = target/2;
            }
            else target++;
            result++;
        }
        return result +startValue - target;
    }
}
