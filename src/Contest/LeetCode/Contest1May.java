package Contest.LeetCode;

import java.util.HashMap;

public class Contest1May {

    public static void main(String[] args) {
//        System.out.println(removeDigit("123",'3'));
//        int[] t = new int[]{1,0,5,3};
//        System.out.println(minimumCardPickup(t));
        System.out.println(appealSum("abbca"));
    }

    public static String removeDigit(String number, char digit) {
        StringBuilder sb = new StringBuilder();
        int n = number.length();
        int count = 0;
        for(int i=0;i<n;i++) {
            if (number.charAt(i) == digit) count++;
        }
        if(count==1) return number.replace(digit+"","");
        int incre = 0;
        int deleted = 0;
        for(int i =0;i< number.length();i++){
            if(number.charAt(i) == digit && deleted == 0){
                incre++;
                if(i+1<number.length() && number.charAt(i+1)>digit){
                    deleted =1;
                }
                else if(incre==count) continue;
                else sb.append(number.charAt(i));
            }else sb.append(number.charAt(i));
        }
        return sb.toString();
    }

    public static int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans  = Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++){
            int val = cards[i];
            if(map.containsKey(val)){
                ans = Math.min(ans,i-map.get(val)+1);
            }
            map.put(val,i);
        }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    public static long appealSum(String s) {
        int n = s.length();
        long count = 0;
        HashMap<String,Long> map = new HashMap<>();
            for(int i=1;i<=n;i++){
                int j = 0;
                while(j+i<=n){
                    String temp = s.substring(j,i+j);
                    j++;
                    String prev = temp.length()>1?temp.substring(1):"";
                    Long distinctCount = 1+map.getOrDefault(prev,0L);
                    if(map.containsKey(prev)){
                        if(prev.contains(temp.charAt(0)+"")){
                            distinctCount = distinctCount -1;
                        }
                    }
                    map.put(temp,distinctCount);
                    count += distinctCount;
                }
            }
        return count;
        }



}
