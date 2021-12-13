package LeetCode.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 11:28 AM 12/13/2021
 */
public class Knapsnack0_1 {


    public static void main(String[] args) {
        //Williamfiset
        //https://www.youtube.com/watch?v=cJ21moQpofY&t=315s
        int capacity = 10;
        int[] V = {1, 4, 8, 5};
        int[] W = {3, 3, 5, 6};
        System.out.println(knapsack(capacity, W, V));

        capacity = 7;
        V = new int[] {2, 2, 4, 5, 3};
        W = new int[] {3, 1, 3, 4, 2};
        System.out.println(knapsack(capacity, W, V));
    }

    public static int knapsack(int capacity,int[] W, int[] V){
        final int N = W.length;
        int[][] dp = new int[N+1][capacity+1];
        for(int i=1;i<=N;i++){
            int w = W[i-1],v=V[i-1];

            for(int sz=1;sz<=capacity ;sz++){
                //Considering not picking up the element
                dp[i][sz] = dp[i-1][sz];

                //Considering including the element and see if it is more profitable
                if(sz>=w && dp[i-1][sz-w]+v>dp[i][sz])
                    dp[i][sz] = dp[i-1][sz-w]+v;


            }
        }
        int sz = capacity;
        List<Integer> itemsSelected = new ArrayList<>();
        //to findout the items that were selected
        for(int i=N;i>=0;i--){
            if(dp[i][sz]!=dp[i-1][sz]){
                int itemIndex = i-1;
                itemsSelected.add(itemIndex);
                sz-=W[itemIndex];
            }
        }
        //return itemsSelected

        return dp[N][capacity];


    }
}
