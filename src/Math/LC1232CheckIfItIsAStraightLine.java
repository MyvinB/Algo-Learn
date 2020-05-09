package Math;

/*
 @author Myvin Barboza
 09/05/20 8:24 AM 
 */
public class LC1232CheckIfItIsAStraightLine {

    static boolean checkStraightLine(int[][] coordinates) {
        int x1=coordinates[0][0];
        int y1=coordinates[0][1];
        int x2=coordinates[1][0];
        int y2=coordinates[1][1];
        float slope=(float)(y2-y1)/(x2-x1);
        float curSlope=0;
        for (int i = 1; i <coordinates.length-1 ; i++) {
            x1=coordinates[i][0];
            y1=coordinates[i][1];
            x2=coordinates[i+1][0];
            y2=coordinates[i+1][1];
            curSlope=(float)(y2-y1)/(x2-x1);
            if(curSlope!=slope) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int a[][]={{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
        System.out.println(checkStraightLine(a));
    }
}