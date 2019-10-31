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
    int max= Integer.MIN_VALUE; /*Please take into consideration the posibility of negative integers*/
    for(int r=0;r<4;r++){
        for (int k = 0; k < 4; k++) {
            for (int i=0 ; i <3 ; i++) {
                for (int j =0; j <3 ; j++) {
                    sum=sum+arr[i+r][j+k];

                }
            }
            sum=sum-arr[r+1][k]-arr[r+1][k+2];
            if(sum>max) max=sum;

            sum=0;

        }

    }
        System.out.println(max);

    }

}
