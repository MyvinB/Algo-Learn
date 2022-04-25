package TopicWise2022.SweepLine;

import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 6:38 AM 4/25/2022
 * Time Taken:
 */
public class LC2251NumberOfFlowersInFullBloom {

    public static void main(String[] args) {

    }

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[0]==b[0]?a[1]-b[1]:a[0]-b[0];
        });
        for(int i=0;i<flowers.length;i++){
            pq.offer(new int[]{flowers[i][0],0});
            pq.offer(new int[]{flowers[i][1],2});
        }

        for(int i=0;i<persons.length;i++){
            pq.offer(new int[]{persons[i],1,i});
        }
        int n = persons.length;
        int count =0;
        int[] ar = new int[n];
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            if(temp[1]==0)count++;
            else if(temp[1]==2) count--;
            else{
                ar[temp[2]] = count;
            }
        }
        return ar;
    }
}
