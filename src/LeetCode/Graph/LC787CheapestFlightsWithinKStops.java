package LeetCode.Graph;

import java.util.PriorityQueue;

/*
 @author Myvin Barboza
 15/06/20 11:50 AM
 HELP happygirtx:https://www.youtube.com/watch?v=H8EeY58LLz0
       Tushar ROy:https://www.youtube.com/watch?v=lAXZGERcDf4
       see the example of dijistra algo in tushar video then understanding happygirtz is eay really simple

 */
public class LC787CheapestFlightsWithinKStops {


    static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int g[][]=new int[n][n];
        for(int f[]: flights){
          g[f[0]][f[1]]=f[2];
        }

        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->(a[0]-b[0]));

        heap.offer(new int[]{0,src,K+1});
        while(!heap.isEmpty()){
            int a[]=heap.poll();
            int price=a[0],place=a[1],remainingStops=a[2];

            if(place==dst) return price;

            else if(remainingStops>0){
                for (int i = 0; i <n ; i++) {
                 if(g[place][i]>0){
                     heap.offer(new int[]{price+g[place][i],i,remainingStops-1});
                 }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[][]={{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(findCheapestPrice(3,a,0,2,1));
    }

}
