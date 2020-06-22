package LeetCode.BitWiseAlgo;/*
 @author Myvin Barboza
 22/06/20 6:26 PM 
 */

public class LC137SingleNumberII {
    public static void main(String[] args) {
        int a[] = {1, 2, 2, 1, 1, 7, 2 };
        System.out.println();
        System.out.println(singleNumber(a));
    }

    public static int singleNumber(int a[]){
        int ones=0, twos=0;
       /*
       First time number appear -> save it in "ones"
       Second time -> clear "ones" but save it in "twos" for later check
       Third time -> try to save in "ones" but value saved in "twos" clear it.
        */
        /*
              1        2       2       1         1       7     2
  one  [1]     [1,2]    [1]    [null]    [null]   [5]   [7] (<=Answer)
  two  [null]  [null]   [2]    [1,2]     [2]      [0]   [0]

  Index form 0 to 6.....====>>>>>>
         */
        for (int i = 0; i <a.length ; i++) {
            // System.out.println(cho);
            ones = (ones^a[i])&~twos;
            twos = (twos^a[i])&~ones;

        }
        return ones;
    }


}
