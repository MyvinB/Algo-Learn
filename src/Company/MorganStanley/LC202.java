package Company.MorganStanley;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mmichaelbarboza
 * on 10:10 AM 2/21/2022
 * Time Taken:
 */
public class LC202 {

    public static void main(String[] args) {

    }

    public boolean isHappy(int n) {
        //Using Set
        Set<Integer> set = new HashSet<>();
        while(set.add(n)){
            int sum=0;
            while(n!=0){
                int val = n%10;
                sum = sum + (int)Math.pow(val,2);
                n = n/10;
            }
            n = sum;
            if(sum==1) return true;
        }
        return false;
    }

    public boolean isHappyFLyod(int n){
        int slow =n;
        int fast = n;
        do{
            slow = calNum(slow);
            fast = calNum(calNum(fast));
            if(slow==1)return true;
        }while(slow!=fast);
        return false;
    }

    public int calNum(int n){
        int sum=0;
        while(n!=0){
            int val = n%10;
            sum = sum + (int)Math.pow(val,2);
            n = n/10;
        }
        return sum;
    }



}
