package LeetCode.Array;

public class LC849MaximizeDistancetoClosestPerson {

    public static void main(String[] args) {
    int a[] ={1,0,0,0,1,0,0,0,0,0,1};
        System.out.println(maxDistToClosest(a));
    }

    static int maxDistToClosest(int[] seats) {
        int last=-1,res=0;
        int n=seats.length;
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){
                res= last<0? i:Math.max(res,(i-last)/2);
                last = i;
            }
        }
        return Math.max(res,n-1-last);
    }
}
