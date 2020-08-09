package LeetCode.DFSANDBFSONLY;/*
 @author Myvin Barboza
 09/08/20 5:26 PM 
 */

import java.util.LinkedList;
import java.util.Queue;

public class LC994RottingOranges {
    public int orangesRotting(int[][] grid) {
        final  int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue=new LinkedList<>();
        int countFresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1) countFresh++;
            }
        }
        System.out.println(countFresh);
        if(countFresh==0) return 0;
        int count=0;
        while(!queue.isEmpty() && countFresh>0){
            int size=queue.size();

            count++;

            for(int i=0;i<size;i++){
                int point[]=queue.poll();

                for(int d[]:dir){
                    int x=point[0]+d[0];
                    int y=point[1]+d[1];
                    if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]==0||grid[x][y]==2)
                        continue;
                    grid[x][y]=2;
                    countFresh--;
                    queue.offer(new int[]{x,y});

                }


            }

        }

        return countFresh==0?count:-1;
    }


}
