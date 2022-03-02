package practise;

import java.sql.SQLOutput;
import java.util.Arrays;
/*Input 1:
    practise.A = [1, 2, 5, -7, 2, 3]

Output 1:
    [1, 2, 5]

Explanation 1:
    The two sub-arrays are [1, 2, 5] [2, 3].
    The answer is [1, 2, 5] as its sum is larger than [2, 3].

Input 2:
    practise.A = [10, -1, 2, 3, -4, 100]

Output 2:
    [100]

Explanation 2:
    The three sub-arrays are [10], [2, 3], [100].
    The answer is [100] as its sum is larger than the other two.*/
public class MaxNonNegativeSubArray {
    public static void main(String[] args) {
        long max= Integer.MIN_VALUE;
        int[] A=//{1, 2, 5, -7, 2, 3};
        {1967513926, 1540383426, -1303455736, -521595368};
        long sum=0;
        int L=0;
        int R=0;
        int maxstart=0;
        int maxend=0;




        while(true){

            while(R<A.length&&A[R]>=0){
                sum=sum+A[R];
                System.out.println(L+"  "+R+" "+sum);
                R++;
            }

            if(L<A.length){

                if(sum>max){

                    maxstart=L;
                    maxend=R;
                    max=sum;

                }
                R=R+1;
                L=R;
                sum=0;

            }
            else break;

        }
        System.out.println(maxstart+" "+maxend+" kndcs"+max);
        System.out.println(Arrays.toString(Arrays.copyOfRange(A, maxstart,   maxend)));
        //Arrays.toString(Arrays.copyOfRange(practise.A, maxstart,   maxend));


    }
}
