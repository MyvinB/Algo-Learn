package practise;

public class OTMinCost {
    public static void main(String[] args) {
        int cost[] = {1,2,1,2,1,2};
        String s = "aabbcc";
        int cost1[] = {3,4,5,6};
        String s1 = "aaaa";
        System.out.println(findCost(cost1,s1));
    }

    static int findCost(int a[],String s){
        int cost=0;
        for(int i=1;i<a.length;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                cost+=Math.min(a[i],a[i-1]);
            }
        }
        return cost;
    }


}
