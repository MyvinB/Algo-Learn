package LeetCodeChallenge.APR2022;

/**
 * @author mmichaelbarboza
 * on 9:09 AM 4/13/2022
 * Time Taken:
 */
public class LC59 {

    public static void main(String[] args) {

    }

    public int[][] generateMatrix(int n) {
        int[][] t = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n-1;
        int colBegin = 0;
        int colEnd = n-1;
        int no =1;
        while(rowBegin<=rowEnd && colBegin<=colEnd){
            for(int i=colBegin;i<=colEnd;i++){
                t[rowBegin][i] =no++;
            }
            rowBegin++;
            for(int i=rowBegin;i<=rowEnd;i++){
                t[i][colEnd] = no++;
            }
            colEnd--;
            if(rowBegin<=rowEnd){
                for(int i=colEnd;i>=colBegin;i--){
                    t[rowEnd][i] = no++;
                }
            }
            rowEnd--;
            if(colBegin<=colEnd){
                for(int i=rowEnd;i>=rowBegin;i--){
                    t[i][colBegin] = no++;
                }
            }
            colBegin++;

        }
        return t;
    }
}
