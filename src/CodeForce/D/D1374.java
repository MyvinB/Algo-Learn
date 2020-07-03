package CodeForce.D;/*
 @author Myvin Barboza
 03/07/20 12:13 PM
 */

import java.util.HashMap;
import java.util.Scanner;

public class D1374 {
/*
Concept
watch the video
seee the formula on codeforces easy but need to understand
https://www.youtube.com/watch?v=I5O6omfi_l0
*
* */

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            long a[]=new long[n];
            HashMap<Long,Long> map=new HashMap<>();

            for (int i = 0; i <n ; i++) {
                a[i]=sc.nextLong();
                if(a[i]%k==0)continue;
                map.put(k-(a[i]%k),map.getOrDefault(k-(a[i]%k),(long)0)+1);
            }
            if(map.isEmpty()) System.out.println(0);
            else {
                long maxCount=0;
                long val=0;;
                for(long key:map.keySet()){
                    if(maxCount<=map.get(key))
                        maxCount=map.get(key);

                }
                for (long key:map.keySet()) {
                    if(map.get(key)==maxCount && key>val)val=key;
                }
                //System.out.println(map);
              //  System.out.println(val+" "+maxCount);
                System.out.println(k*(maxCount-1)+val+1);
            }




        }
    }


}
