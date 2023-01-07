package Year2023.Jan;

public class LC134 {

    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumOfCost = 0;
        int sumOfGas = 0;
        int total = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            sumOfGas+= gas[i];
            sumOfCost+=cost[i];
            total += gas[i]-cost[i];
            if(total<0){
                start = i+1;
                total = 0;
            }
        }
        if(sumOfGas<sumOfCost) return -1;
        else return start;
    }
}
