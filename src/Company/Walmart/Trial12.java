package Company.Walmart;

/**
 * @author mmichaelbarboza
 * on 10:39 PM 3/5/2022
 * Time Taken:
 */
public class Trial12 {
    public static void main(String[] args) {
        int[] t = new int[]{5,8,6,3,19};
        int min = Integer.MAX_VALUE;
        int max = 0;
        int shift = 8;
        for(int j=0;j<t.length;j++){
            min =Math.min(min,t[j]);
            max =Math.max(max,t[j]);
        }
        for(int i=min ;i<=max+1 ; i++){
            int sleepCount = 0;
            int sum =0;
            for(int j=0;j<t.length;j++){
                if(t[j]<i){
                    sleepCount++;
                    sum+=1;
                    continue;
                }
                int c = t[j]%i==0?t[j]/i:(t[j]/i)+1;
                sum +=c;
            }
            if(sum==shift && sleepCount!=0){
                System.out.println(i);
                break;

            }
        }

    }
}
