package LeetCodeChallenge.JAN2022;

/**
 * @author mmichaelbarboza
 * on 12:57 PM 1/21/2022
 */
public class LC134 {

    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
         int sumOfGas=0;
         int sumOfCost=0;
         int tank=0;
         int start=0;
         for(int i=0;i<gas.length;i++){
             sumOfCost+=cost[i];
             sumOfGas+=gas[i];
             tank+=gas[i]-cost[i];
             if(tank<0){
                 start=i+1;
                 tank=0;
             }
         }
         if(sumOfGas<sumOfCost) return -1;
         else return start;
    }
}
