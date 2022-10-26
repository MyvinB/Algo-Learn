package LeetCodeChallenge.Oct2022.Graph;
/*
*Problem LInk
* https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=flood-fill-algorithm
* */
public class FloodFillAlgorithm {

    public static void main(String[] args) {

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] res = image;
        dfs(image,image[sr][sc],sr,sc,newColor);
        return res;
    }

    public void dfs(int[][] image,int intialColor, int sr,int sc,int newColor){
        int[][] dir = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=intialColor ||image[sr][sc]==newColor) return;
        image[sr][sc] = newColor;
        for(int[] d:dir){
            int x = sr+d[0];
            int y = sc+d[1];
            dfs(image,intialColor,x,y,newColor);
        }
    }
}

