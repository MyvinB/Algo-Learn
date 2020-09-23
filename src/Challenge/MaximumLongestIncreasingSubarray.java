package Challenge;/*
 @author Myvin Barboza
 23/09/20 3:30 PM 
 */

import java.util.Scanner;

public class MaximumLongestIncreasingSubarray {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t--!=0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)arr[i]=sc.nextInt();
            int max = 1, len = 1;
            int lend=1;
            for(int i=1;i<n;i++){
                if(arr[i]>=arr[i-1]){
                    len++;
                }else len=1;
                if(arr[i]<=arr[i-1])lend++;
                else lend=1;
               max=Math.max(len,max);
               max=Math.max(max,lend);
            }

            System.out.println(max);


        }

    }



}
