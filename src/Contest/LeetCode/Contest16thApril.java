package Contest.LeetCode;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 7:53 PM 4/16/2022
 * Time Taken:
 */
public class Contest16thApril {

    public static void main(String[] args) {
//        int[] t = new int[]{-4,-2,1,4,8};
//        System.out.println(findClosestNumber(t));
        ATM t = new ATM();
        t.deposit(new int[]{0,0,1,2,1});
        System.out.println(t.withdraw(600));
        t.deposit(new int[]{0,1,0,1,1});
        System.out.println(t.withdraw(600));
        System.out.println(t.withdraw(550));
    }

    public static int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int val = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(Math.abs(nums[i])<=min ){
                min = Math.min(min,Math.abs(nums[i]));
                val = nums[i];
            }
        }
        return val;

    }

    static class ATM {
        int[] t = new int[]{20, 50, 100, 200, 500};
        int[] curAccount ;

        public ATM() {
        curAccount= new int[]{0,0,0,0,0};

        }

        public void deposit(int[] banknotesCount) {
            for(int i=0;i<banknotesCount.length;i++){
                curAccount[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            double sum = amount;
            int[] tempT = new int[curAccount.length];
            int[] temp = Arrays.copyOf(curAccount,curAccount.length);
            for(int i=curAccount.length-1;i>=0;i--){
                if(curAccount[i]>0){
                    double no = (long)sum/t[i];
                    double possibleAmount = no*t[i];
                    if(no<=curAccount[i] && possibleAmount<=sum){
                        sum-=possibleAmount;
                        curAccount[i] -= no;
                        tempT[i] += no;
                    }
                }
                if(sum==0) return tempT;
            }
            curAccount = temp;
            return new int[]{-1};
        }
    }
}
