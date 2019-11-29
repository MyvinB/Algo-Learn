import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
import java.util.Arrays;
/*Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

class TwoSum {

    public static void main(String[] args) {
       int [] A={2,7,11,15};
       int target=9;
       int i=0,j=0,sum=0;
       while(i<A.length){
           sum=sum+A[i];
           j=0;
           while (j<A.length){
               //System.out.println(i+" "+j);
               if(sum+A[j]==target&&i!=j){
                   System.out.println(i+" "+j);
                   break;
               }
               j++;
           }
           sum=0;
           i++;
       }


    }
}
