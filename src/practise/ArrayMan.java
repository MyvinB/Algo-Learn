package practise;

import java.util.Arrays;

/*practise.A : [ 4, 0, 2, 1, 3 ]
// After Replacing practise.A[i] = n*(B[i]%n)+practise.A[i]
practise.A : [19, 20, 12, 1, 8 ]

// Kindly note that B[i] = practise.A[practise.A[i]], or simply the value we need to replace  the current value with

// Now, just divide every element by n to get our final array

practise.A[i] = practise.A[i]/n

practise.A : [3, 4, 2, 0, 1]
//Which is the required answer*/

public class ArrayMan {
    public static void main(String[] args) {
        int[] A={4,0,2,1,3};
        int n=A.length;
        for (int i = 0; i <A.length ; i++) {
            A[i]=n*(A[A[i]]%n)+A[i];
        }

        System.out.println(Arrays.toString(A));
    }
}
