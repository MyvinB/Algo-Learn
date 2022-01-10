package LeetCodeChallenge.JAN2022;

/**
 * @author mmichaelbarboza
 * on 5:37 PM 1/9/2022
 */
public class LC1041 {
    public static void main(String[] args) {
        System.out.println(3%4);
    }

    public boolean isRobotBounded(String instructions) {
        //Imp logic 1 left = 3 right or 1 right = 3left
        //if a circle the direction will never point in the same
        //GLLLL
        //
        int[][] dir = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        int k=0;
        int x=0,y=0;
        for(int i=0;i<instructions.length();i++){
            if(instructions.charAt(i)=='L'){
                k=(k+1)%4;
            }else if(instructions.charAt(i)=='R'){
                k=(k+3)%4;
            }
            else{
                x+=dir[k][0];
                y+=dir[k][1];
            }
        }
        return x==0 && y==0 ;
    }
}
