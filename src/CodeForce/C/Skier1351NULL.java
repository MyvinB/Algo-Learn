package CodeForce.C;
/*
 @author Myvin Barboza
 11/05/20 11:38 AM 
 */
import java.util.*;
import java.io.*;

public class Skier1351NULL {
    public static void main(String args[]) {
        Scanner in=new Scanner (System.in);
        int t=in.nextInt();
        while(--t>=0) {
            char s[]=in.next().toCharArray();
            int xe=0,ye=0, xs=0, ys=0;
            int n=s.length;
            HashSet<String> hset=new HashSet<>();
            long ans=0;
            for(int i=0;i<n;i++) {
                xs=xe;
                ys=ye;
                if(s[i]=='E')
                    xe++;
                else if(s[i]=='W')
                    xe--;
                else if(s[i]=='N')
                    ye--;
                else
                    ye++;

                String val1 = xs+"_"+ys+"_"+xe+"_"+ye;
                String val2 = xe+"_"+ye+"_"+xs+"_"+ys;
                if(hset.contains(val1) || hset.contains(val2))
                    ans=ans+1;
                else {
                    ans=ans+5;
                    hset.add(val1);
                }
            }

            System.out.println(ans);
        }
    }
}