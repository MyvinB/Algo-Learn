package LeetCode.Array;/*
 @author Myvin Barboza
 21/08/20 1:29 PM 
 */

public class LC905SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int even=0;
        int odd=A.length-1;
        int ar[]=new int[A.length];
        for(int i=0;i<A.length;i++){
            int temp=A[i];
            if(A[i]%2==0){
                ar[even++]=temp;
            }
            else{
                ar[odd--]=temp;
            }
        }
        return ar;

    }

    public int[] sortArrayByParityInplace(int[] A) {
        int i=0;
        int j=A.length-1;
        while(i<j){
            while(i<j && A[i]%2==0)i++;
            while(i<j && A[j]%2!=0)j--;

            if(i<j){
                int temp=A[i];
                A[i]=A[j];
                A[j]=temp;
            }
        }
        return A;
    }

}
