/*Sample Input
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output
19

2 4 4
  2
1 2 4*/
public class HourGlass {

    public static void main(String[] args) {
    int[][] arr={
            { 1, 1, 1, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 0 },
            { 1, 1, 1, 0, 0, 0 },
            { 0, 0, 2, 4, 4, 0 },
            { 0, 0, 0, 2, 0, 0 },
            { 0, 0, 1, 2, 4, 0 }
    };
    int sum=0;
    int max=0;
        for (int k = 0; k < 4; k++) {
            for (int i=0 ; i <3 ; i++) {
                for (int j =0; j <3 ; j++) {
                    sum=sum+arr[i][j];
                }
            }
        }

    }

}
