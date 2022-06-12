package Contest.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Constest11June {

    public static void main(String[] args) {
//        System.out.println(strongPasswordCheckerII("IloveLe3tcode!"));//
  int[] s = new int[]{3,1,2};
        int[] p = new int[]{8,5,8};
        System.out.println(Math.ceil((double) 16/(double) 8));
        System.out.println(Arrays.toString(successfulPairs(s,p,16)));

    }

    public static boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        String special = "!@#$%^&*()-+";
        HashSet<Character> characters = new HashSet<>();
        for(int i=0;i<special.length();i++){
            characters.add(special.charAt(i));
        }
        if(n<8) return false;
        boolean isUpper = false;
        boolean isLower = false;
        boolean isDigit = false;
        boolean containsSpecialCharacter = false;
        for(int i=0;i<n;i++){
            char cur= password.charAt(i);
            System.out.println(i);
            char next = i!=n-1?password.charAt(i+1):'\0';
            if(i!=n-1 && cur==next) return false;
            if(Character.isDigit(cur)) isDigit = true;
            if(Character.isUpperCase(cur)) isUpper = true;
            if(characters.contains(cur)) containsSpecialCharacter = true;
            if(Character.isLowerCase(cur)) isLower = true;
        }
        return isDigit && isLower && isUpper && containsSpecialCharacter;
    }
    //Fail
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        for(int i=0;i<spells.length;i++){
            long aSpell = (long)Math.ceil((double) success/(double)spells[i]);
            if(aSpell!=(int)aSpell) spells[i] = Integer.MAX_VALUE;
            else spells[i] = (int)aSpell;
        }
        int t[] = new int[spells.length];
        for(int i=0;i<spells.length;i++){
            int count=0;
            for(int j=0;j<potions.length;j++){
                if(potions[j]>=spells[i]) count++;
            }
            t[i] = count;
        }
        return t;
    }

    //Fail Have to upsolve
    public long countSubarrays(int[] nums, long k) {
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0L,0);
        long preSum = 0;
        for(int i=0;i<nums.length;i++){
            preSum += nums[i];
            map.put(preSum,i);
        }
        return 0;

    }
}
