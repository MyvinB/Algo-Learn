package TopicWise2022.Math;

/**
 * @author mmichaelbarboza
 * on 3:39 PM 4/17/2022
 * Time Taken:
 */
public class LC2240NumberOfWaysToBuyPensAndPencils {

    public static void main(String[] args) {

    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans  = 0;
        for(int i=0;;i++){
            long val = total - cost1*i;
            if(val<0) break;
            //Plus one is for zerro condition
            ans += Math.floor(val/cost2)+1;
        }
        return ans;
    }
}
