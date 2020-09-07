package LeetCode.Array;

public class LC835ImageOverlap {
    public static void main(String[] args) {
        int a[][] = {{1, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int b[][] = {{0, 0, 0}, {0, 1, 1}, {0, 0, 1}};
        largestOverlap(a,b);

    }

      static int largestOverlap(int[][] A, int[][] B) {
            int n=A.length;

            int count=0;
            int max=0;
            //calculated for shifts
            for(int rowShift=0;rowShift<n;rowShift++){
                for(int colShift=0;colShift<n;colShift++){

                   max=Math.max(maxVal(A,B,rowShift,colShift),max);
                }
            }
            return max;
        }

        static int maxVal(int[][] A,int[][] B,int x,int y){
            int count=0;
            int n=A.length;
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < n; j++) {
                    int iB=i+x;
                    int jB=j+y;
                    //to avoid Array out of bounds
                    if(iB<0 || iB>=A.length ||jB<0 ||jB>=A.length)continue;

                    if(A[i][j]==1 && B[iB][jB]==1)count++;
                }
            }
           return count;
        }
}
