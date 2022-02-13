package LeetCodeChallenge.Feb2022.practise;

/**
 * @author mmichaelbarboza
 * on 6:54 PM 2/13/2022
 * Time Taken:
 */
public class LC2170 {

    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{3,3,3,4,3,3,3}));
    }

    public static int minimumOperations(int[] nums) {
        int[] evenFreq = new int[100001];
        int[] oddFreq = new int[100001];
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                evenFreq[nums[i]]++;
            }else oddFreq[nums[i]]++;
        }
        int evenIndex = 0;
        int oddIndex = 0;
        int maxEvenFreq = 0;
        int maxEvenSecondFreq = 0;
        int maxOddFreq = 0;
        int maxOddFreqSecond = 0;


        for(int i=0;i<100001;i++){
            if(evenFreq[i]>maxEvenFreq){
                maxEvenSecondFreq = maxEvenFreq;
                maxEvenFreq = evenFreq[i];
                evenIndex = i;
            }else if(evenFreq[i]>maxEvenSecondFreq){
                maxEvenSecondFreq = evenFreq[i];
            }
            if(oddFreq[i]>maxOddFreq){
                maxOddFreqSecond = maxOddFreq;
                maxOddFreq = oddFreq[i];
                oddIndex=i;
            }else if(oddFreq[i]>maxOddFreqSecond){
                maxOddFreqSecond = oddFreq[i];
            }
        }
        if(evenIndex!=oddIndex){
            return n- maxEvenFreq -maxOddFreq;
        }
        else return Math.min(n-maxEvenFreq-maxOddFreqSecond,n-maxOddFreq-maxEvenSecondFreq);
    }
}
