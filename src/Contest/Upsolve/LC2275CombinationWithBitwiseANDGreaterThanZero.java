package Contest.Upsolve;


public class LC2275CombinationWithBitwiseANDGreaterThanZero {

    public static void main(String[] args) {

    }

    public int largestCombination(int[] candidates) {
        int n = candidates.length;
        int binarySetCount[] = new int[32];int max =0;
        for(int i=0;i<32;i++){
            for(int el:candidates){
                if(((el>>i)&1)==1 ){
                    binarySetCount[i] ++;
                }
            }
            max = Math.max(max,binarySetCount[i]);
        }
        return max;
    }
}
