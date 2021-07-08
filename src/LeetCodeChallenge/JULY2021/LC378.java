package LeetCodeChallenge.JULY2021;

import java.util.PriorityQueue;

public class LC378 {
    public static void main(String[] args) {

    }
    //Time 0(m*n*logk)
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->(b-a));
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                pq.offer(matrix[i][j]);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }

}
