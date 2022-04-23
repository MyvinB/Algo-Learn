package TopicWise2022.DP.DistinctWays;

/**
 * @author mmichaelbarboza
 * on 5:31 PM 4/23/2022
 * Time Taken:
 */
public class LC801MinimumSwapsToMakeSequencesIncreasing {
    public static void main(String[] args) {

    }

    public int minSwap(int[] A, int[] B) {
        int N = A.length;
        int[] swap = new int[100000];
        int[] not_swap = new int[100000];
        //For first condition we do notthing but just swap as nothig matters
        swap[0] = 1;
        for(int i=1;i<N;i++){
            not_swap[i] = swap[i] = N;
            if(A[i-1]<A[i] && B[i-1]<B[i]){
                //Here we swap two times to reset the value if it's only increasing since the first time swap was performed and not needed
                swap[i] = swap[i-1]+1;
                //Do not swap value we just take the prev value as we are not swapping
                not_swap[i] = not_swap[i-1];
            }

            if(A[i-1]<B[i] && B[i-1]<A[i]){
                //here we if swap at i we do not swap at i-1 to maintain an increasing order
                // we add one here to show we have swapped at i so plus 1 and did not perform any swap at i-1
                swap[i] = Math.min(swap[i],not_swap[i-1]+1);
                // If we are not swaping here we swap at i-1
                not_swap[i] = Math.min(not_swap[i],swap[i-1]);
            }
        }
        return Math.min(swap[N-1],not_swap[N-1]);
    }
}
