package Company.Amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mmichaelbarboza
 * on 10:32 AM 3/8/2022
 * Time Taken:
 */
public class LC994RottingOranges {

    public static void main(String[] args) {
        int[][] t = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(t));
    }

    public static int orangesRotting(int[][] grid) {
        //left right up down
        final int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1) freshOranges++;
            }
        }
        int minuteCount = 0;
        // Think of the last fresh orange its rotten and put in the queue but since there are no more fresh oranges why bother iterating and increasing the minute count
        while(!queue.isEmpty() && freshOranges>0){
            //For every level the minuite is increasing
            minuteCount++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] cur = queue.poll();
                //Adding all to the que
                for(int[] d:dir){
                    int x = cur[0] +d[0];
                    int y = cur[1] +d[1];
                    //if it passes boundaries and is empty or already rotten we do not consider it
                    if(x<0 || x>= m || y<0 || y>=n || grid[x][y] ==2 || grid[x][y]==0) continue;
                    //Rotting the levels we have
                    grid[x][y] = 2;
                    //Decrementing fresh orange count
                    freshOranges--;
                    queue.add(new int[]{x,y});
                }
            }
        }

        return freshOranges==0?minuteCount:-1;
    }
}
