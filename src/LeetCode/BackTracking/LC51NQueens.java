package LeetCode.BackTracking;/*
 @author Myvin Barboza
 17/06/20 9:47 AM 
 */

import java.util.ArrayList;
import java.util.List;

public class LC51NQueens {

    static List<List<String>> solveNQueens(int n) {
        List<List<String>> list=new ArrayList<>();
        solveList(0,n,new ArrayList<>(),list);
        return list;
    }

    static void  solveList(int row,int n,List<Integer> colList,List<List<String >> list){
        if(row==n){
            // got our decsions goal as we found n
            list.add(generateString(colList));
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

    static List<String> generateString(List<Integer> colList){
        int n=colList.size();
        List<String> list=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j <n ; j++) {
                if(j==colList.get(i))sb.append("Q");
                else sb.append(".");
            }
            list.add(sb.toString());
        }
        return list;
    }




    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
