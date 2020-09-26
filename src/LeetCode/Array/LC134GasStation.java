package LeetCode.Array;

public class LC134GasStation {
    //O(n2)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        for(int i=0;i<n;i++){
            int total=0,stepCount=0,j=i;
            while(stepCount<n){
                total+=gas[j%n]-cost[j%n];
                if(total<0)break;
                stepCount++;
                j++;

                if(stepCount==n && total>=0){
                    return i;
                }
            }

        }
        return -1;
    }
    //O(n)
    public int canCompleteCircuitOn(int[] gas, int[] cost) {
        int n=gas.length;
        int total=0;
        int index=0,tank=0;
        for(int i=0;i<n;i++){
            int consume=gas[i]-cost[i];
            tank+=consume;
            if(tank<0){
                tank=0;
                index=i+1;
            }
            total+=consume;

        }

        return total<0?-1:index;
    }
}
