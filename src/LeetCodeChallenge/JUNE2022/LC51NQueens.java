package LeetCodeChallenge.JUNE2022;

import Challenge.A;

import java.util.ArrayList;
import java.util.List;

public class LC51NQueens {


    public static void main(String[] args) {

    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        solveList(0,n,new ArrayList<>(),res);
        return res;
    }


    public void solveList(int row,int n,List<Integer> colList,List<List<String>> res){
        if(row==n){
            res.add(generateString(colList));
        }else {
            for(int col=0;col<n;col++){
                colList.add(col);
                if(isValid(colList)){
                    solveList(row+1,n,colList,res);
                }
                colList.remove(colList.size()-1);
            }
        }
    }

    public boolean isValid(List<Integer> colList){
        int currentRow = colList.size()-1;
        for(int row=0;row<currentRow;row++){
            int colDiff = Math.abs(colList.get(currentRow)-colList.get(row));
            int rowDiff = currentRow - row;
            //notic the pattern when row diff or col diff we be the same on both positive and negatice diag
            if(colDiff==0 ||colDiff==rowDiff) return false;
        }
        return true;
    }

    public List<String> generateString(List<Integer> colList){
        int n= colList.size();

        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(j==colList.get(i)) sb.append('Q');
                else sb.append('.');
            }
            list.add(sb.toString());
        }
        return list;
    }
}
