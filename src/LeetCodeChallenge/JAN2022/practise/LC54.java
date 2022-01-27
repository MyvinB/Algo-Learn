package LeetCodeChallenge.JAN2022.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 11:34 AM 1/27/2022
 */
public class LC54 {

    /*
    * right
    * down
    * left
    * up
    * */

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(test));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length-1;
        while(rowBegin<= rowEnd && colBegin<=colEnd){
            //Going left
            for(int i=colBegin;i<=colEnd;i++){
                res.add(matrix[rowBegin][i]);
            }
            //incrementing done with row
            rowBegin++;
            //Going down
            for(int i= rowBegin;i<=rowEnd;i++ ){
                res.add(matrix[i][colEnd]);
            }
            //Done with this col
            colEnd--;
            //Going right
            if(rowBegin<=rowEnd){
                for(int i=colEnd;i>=colBegin;i--){
                    res.add(matrix[rowEnd][i]);
                }
            }

            //Done with this row
            rowEnd--;
            if(colBegin<=colEnd){
                for(int i=rowEnd;i>=rowBegin;i--){
                    res.add(matrix[i][colBegin]);
                }
            }

            colBegin++;
        }
        return res;
    }
}
