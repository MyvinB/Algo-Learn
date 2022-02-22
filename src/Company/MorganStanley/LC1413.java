package Company.MorganStanley;

/**
 * @author mmichaelbarboza
 * on 7:05 AM 2/22/2022
 * Time Taken:
 */
public class LC1413 {

    public static void main(String[] args) {
        int[] t = new int[]{2,3,5,-5,-1};
        System.out.println(minStartValue(t));
    }

    public static int minStartValue(int[] nums) {
        int sum =0;
        int min = Integer.MAX_VALUE;
        int flag =0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
            min = Math.min(min,sum);
            if(sum<0) flag = 1;
        }
        if(flag==0){
            min = 1;
        }
        return min<0?min*-1+1:min;
    }


    public static int minStartValueOpti(int[] nums) {
        int sum =0;
        int min = 0;

        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
            min = Math.min(min,sum);
        }
        return 1-min;
    }
}
