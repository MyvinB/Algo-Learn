package Contest.LeetCode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Contest22May {

    public static void main(String[] args) {
        //System.out.println(percentageLetter("foobar",'o'));
//        int[] c = new int[]{10,2,2};
//        int[] t = new int[]{2,2,0};
//        System.out.println(maximumBags(c,t,100));
        int[] t = new int[]{747,812,112,1230,1426,1477,1388,976,849,1431,1885,1845,1070,1980,280,1075,232,1330,1868,1696,1361,1822,524,1899,1904,538,731,985,279,1608,1558,930,1232,1497,875,1850,1173,805,1720,33,233,330,1429,1688,281,362,1963,927,1688,256,1594,1823,743,553,1633,1898,1101,1278,717,522,1926,1451,119,1283,1016,194,780,1436,1233,710,1608,523,874,1779,1822,134,1984};
        System.out.println(totalStrength(t));
//        double[] tq = new double[]{747,812,112,1230,1426,1477,1388,976,849,1431,1885,1845,1070,1980,280,1075,232,1330,1868,1696,1361,1822,524,1899,1904,538,731,985,279,1608,1558,930,1232,1497,875,1850,1173,805,1720,33,233,330,1429,1688,281,362,1963,927,1688,256,1594,1823,743,553,1633,1898,1101,1278,717,522,1926,1451,119,1283,1016,194,780,1436,1233,710,1608,523,874,1779,1822,134,1984};
//        double sum  = 0;
//        for(int i =0;i<tq.length;i++){
//            sum+= tq[i];
//        }
//        System.out.println(sum);
    }

    public static int percentageLetter(String s, char letter) {
        int n = s.length();
        if(!s.contains(letter+"")) return 0;
        int count =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==letter) count++;
        }
        return (count*100)/(n);
    }

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.offer(capacity[i]-rocks[i]);
        }
        int count=0;
        while(!pq.isEmpty()){
            int toAdd = pq.poll();
            if(toAdd==0){
                count++;
            }else if(toAdd<=additionalRocks){
                additionalRocks -= toAdd;
                count++;
            }else break;
        }
        return count;

    }


    public static int totalStrength(int[] strength) {
        int n = strength.length;
        double[][] min = new double[n][n];
        double[][] preSum = new double[n][n];
        double total =0;
        int mod = 1000000009;
        for(int len=1;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j = i+len-1;
                if(i==j) {
                    min[i][j] = strength[i];
                    preSum[i][j] = strength[i];
                }else{
                    min[i][j] = Math.min(min[i][j-1],strength[j]);
                    preSum[i][j] = strength[j] +preSum[i][j-1];
                }
                double val = min[i][j] * preSum[i][j];
                val = val%mod;
                total = (total+val)%mod;
            }
        }
        return (int)total;
    }
}
