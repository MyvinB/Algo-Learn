package LeetCode.Array;

import java.util.Arrays;

/*
 @author Myvin Barboza
 26/04/20 12:49 PM 
 */public class DistributeCandiesToPeopleLC1103 {

   static int[] distributeCandies(int candies, int num_people) {
        int a[]=new int[num_people];
        int loops=0;
        int i=0;
        while(candies>0){
            if(i==num_people){
                i=0;
                loops++;
            }

            int cur_candy=(loops*num_people)+(i+1);

            if(candies-cur_candy<=0){
                a[i]+=candies;
            }
            else{
                a[i]+=cur_candy;
            }
            i++;
            candies-=cur_candy;

        }




        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(10,3)));
    }
}