package TopicWise2022.Math;

/**
 * @author mmichaelbarboza
 * on 4:10 PM 4/3/2022
 * Time Taken:
 */
public class LC2224 {

    public static void main(String[] args) {

    }


    public int convertTime(String current, String correct) {
        int currentMin = getTime(current);
        int correctMin = getTime(correct);
        int[] d = new int[]{60,15,5,1};
        int count = 0;
        int diff = correctMin - currentMin;
        for(int i =0;i<d.length;i++){
            count += diff/d[i];
            if(diff%d[i]==0){
                break;
            }else {
                diff = diff%d[i];
            }
        }

        return count;
    }

    public int getTime(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60+ Integer.parseInt(t[1]);
    }
}
