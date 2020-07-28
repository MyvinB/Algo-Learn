package LeetCode.Array;/*
 @author Myvin Barboza
 28/07/20 7:31 PM 
 */

public class LC517SuperWashingMachines {

    public static void main(String[] args) {

    }
    public int findMinMoves(int[] machines) {
        int n=machines.length;
        int sum=0;
        for(int i=0;i<n;i++)sum+=machines[i];
        if(sum%n!=0) return -1;
        int toRight=0;

        int total=sum/machines.length;
        int res=0;
        for(int i:machines){
            toRight+=i-total;
            res=Math.max(res,Math.max(Math.abs(toRight),i-total));
        }
        return res;
    }
}
