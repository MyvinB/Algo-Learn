package LeetCode.Math;

public class LC1041RobotBoundedInCircle {

    public boolean isRobotBounded(String s) {
        final int dir[][]={{0,1},{-1,0},{0,-1},{1,0}};
        int x=0,y=0,i=0;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='L'){
                i=(i+1)%4;
            }
            else if(s.charAt(j)=='R'){
                i=(i+3)%4;
            }
            else {
                x=x+dir[i][0];
                y=y+dir[i][1];
            }
        }

        return x==0 && y==0 || i>0;
    }
}
