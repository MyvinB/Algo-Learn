package LeetCodeChallenge.JULY2021;

public class LC1220 {
    public static void main(String[] args) {
        System.out.println(countVowelPermutation(144));
    }
 /*
 Base logic
 Each vowel 'a' may only be followed by an 'e'.
 Each vowel 'e' may only be followed by an 'a' or an 'i'.
 Each vowel 'i' may not be followed by another 'i'.
 Each vowel 'o' may only be followed by an 'i' or a 'u'.
 Each vowel 'u' may only be followed by an 'a'.
=== In other words:
 'a' can be followed by {'e'}
 'e' can be followed by {'a', 'i'}
 'i' can be followed by {'a', 'e', 'o', 'u'}
 'o' can be followed by {'i', 'u'}
 'u' can be followed by {'a'}
 === In other words:
 'a' can follow {'e', 'i', 'u'}
 'e' can follow {'a', 'i'}
 'i' can follow {'e', 'o'}
 'o' can follow {'i'}
 'u' can follow {'i', 'o'}
*/

    public static int countVowelPermutation(int n) {
        int MOD = 1000_000_007;
        long a =1,e=1,i=1,o=1,u=1;
        long totalPerm = 0;
        for (int j = 2; j <=n ; j++) {
            long aa= a;
            long ee= e;
            long ii=i;
            long oo=o;
            long uu=u;
            a = (ee+ii+uu)%MOD;
            e = (aa+ii)%MOD;
            i = (ee+oo)%MOD;
            o = (ii)%MOD;
            u = (ii+oo)%MOD;
        }
        return (int)((a+e+i+o+u)%MOD);
    }

}
