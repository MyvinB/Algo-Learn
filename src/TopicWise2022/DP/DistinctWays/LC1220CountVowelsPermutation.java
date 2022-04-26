package TopicWise2022.DP.DistinctWays;

/**
 * @author mmichaelbarboza
 * on 8:51 AM 4/26/2022
 * Time Taken:
 */
public class LC1220CountVowelsPermutation {

    public static void main(String[] args) {

    }

    public int countVowelPermutation(int n) {
        int mod = 1000000009;
        long a=1,e=1,i=1,o=1,u=1;
        for(int k=2;k<=n;k++){
            long aa = a;
            long ee = e;
            long ii = i;
            long oo = o;
            long uu = u;
            a = (aa+ii+uu) %mod;
            e = (aa+ii)%mod;
            i = (oo+ee)%mod;
            o = (ii)%mod;
            u = (ii+oo)%mod;
        }
        return (int)((a+e+i+o+u)%mod);
    }
}
