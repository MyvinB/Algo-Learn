package practise;

import java.lang.reflect.Array;
import java.util.Arrays;

public class  KadaneAlgo{
 //Largest Sum Contiguous Subarray

    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = 0, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {

            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
            //System.out.println(" after "+max_ending_here+" i= "+i);
        }
        return max_so_far;
    }

    public static void main(String[] args) {
      int[] A={-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArraySum(A));

    }
}
