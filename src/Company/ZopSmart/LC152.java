package Company.ZopSmart;

/**
 * @author mmichaelbarboza
 * on 3:09 PM 2/1/2022
 * Time Taken:
 */
public class LC152 {

    public static void main(String[] args) {
        int t[] = new int[]{-2,0,-1};
        System.out.println(maxProduct(t));
    }

    public static int maxProduct(int[] A) {
        int min = A[0];
        int max = A[0];
        int res =A[0];
        for(int i=1;i<A.length;i++){
            int t0 = A[i]*min;
            int t1 = A[i]*max;
            min = Math.min(A[i],Math.min(t0,t1));
            max = Math.max(A[i],Math.max(t0,t1));
            res = Math.max(res,max);
        }
        return res;
    }
}

