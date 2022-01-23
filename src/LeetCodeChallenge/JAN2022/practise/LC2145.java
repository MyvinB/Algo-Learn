package LeetCodeChallenge.JAN2022.practise;

/**
 * @author mmichaelbarboza
 * on 11:18 AM 1/23/2022
 */
public class LC2145 {

    public static void main(String[] args) {
        int diff[] = new int[]{1,-3,4};
        System.out.println(numberOfArrays(diff,1,6));
    }

    public static int numberOfArrays(int[] differences, int lower, int upper) {
//        Let's say the given sequence is [1,-4,5]. Let's assume our first number in the original sequence is a. Then our original sequence will be [a,a+1,a-3,a+2] right! So, tell me here the minimum term is the 3rd term (a-3) and the max term is (a+2). And they are always the min and max term independant of a. Now say the lower bound is 3 and upper bound is 15. So, a-3>=3 and therfore a>=6 and a+2<=15 <=> a<=13. So a can be anything between [6,15] and we can always form the desired sequence.
        long current =0;long min=0,max=0;
        int res=0;
        for(int i=0;i<differences.length;i++){
            current+=differences[i];
            min = Math.min(min,current);
            max = Math.max(max,current);
        }
        int upperBound = (int) (upper - max);
        int lowerBound = (int) (lower - min);

        if(upperBound-lowerBound+1>0) res = upperBound-lowerBound+1;
        return res;
    }
}
