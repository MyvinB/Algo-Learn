package LeetCode.BackTracking;/*
 @author Myvin Barboza
 17/06/20 4:00 PM 
 */

import java.util.ArrayList;
import java.util.List;

public class LC52NQUEEN2 {


    static int totalNQueens(int n) {
        List t=new ArrayList();
        solveList(0,n,new ArrayList<>(),t);
        return t.size();
    }
    static void  solveList(int row,int n,List<Integer> colList,List list){
        if(row==n){
            // got our decsions goal as we found n
            list.add(0);
            return;
        }
        else{
            for (int col = 0; col <n ; col++) {
                colList.add(col);
                if(isValid(colList)){
                    //if the tree is valid move on to the next row
                    solveList(row+1,n,colList,list);
                }
                // back track remove your decision choice
                colList.remove(colList.size()-1);
            }
        }
    }

    static  boolean isValid(List<Integer> colList){
        int currentRow=colList.size()-1;
        for (int row = 0; row <currentRow ; row++) {
            int colDiff=Math.abs(colList.get(currentRow)-colList.get(row));
            int rowDiff=currentRow-row;
            //in the same coln or in the same diagonal see with paper and pen
            if(colDiff==0 || colDiff==rowDiff) return false;
        }

        return true;
    }




    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
