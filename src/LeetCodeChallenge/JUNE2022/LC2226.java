package LeetCodeChallenge.JUNE2022;

public class LC2226 {

    public static void main(String[] args) {
        int[] t = new int []{5,6,4,10,10,1,1,2,2,2};
        int k = 3;
        System.out.println(maximumCandies(t,9));
    }

    public static int maximumCandies(int[] candies, long k) {
        int max = 0;
        int n = candies.length;
        for(int i=0;i<n;i++) max = Math.max(max,candies[i]);
        int l = 0;
        int h = max;

        while(l<h){
            int mid = (l+h+1)/2;
            long sum =0;
            for(int i=0;i<n;i++){
                sum += candies[i]/mid;
            }
            if(k>sum) h=mid-1;
            else l=mid;
        }
        return l;
    }
}
