package CodeForce.A;/*
 @author Myvin Barboza
 01/07/20 3:27 PM 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A230 {

    public static void main(String[] args) throws IOException {
//
        Scanner in=new Scanner(System.in);
        int s=in.nextInt();
        int n=in.nextInt();
        int a[][]=new int[n][2];

        for(int i=0;i<n;i++){
            a[i][0]=in.nextInt();
            a[i][1]=in.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            if(s>a[i][0])
            {
                s+=a[i][1];
                a[i]=a[n-1];
                n--;
                i=-1;
            }
        }
        if(n==0)
            System.out.println("YES");
        else
            System.out.println("NO");





        //accepted code but long intuitive code above
        /*
           BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String sArr[]=br.readLine().split(" ");
        int s=Integer.parseInt(sArr[0]),n=Integer.parseInt(sArr[1]);

        boolean flag=false;
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->(a[0]-b[0]));
        for(int i=0;i<n;i++){
            String sArr1[]=br.readLine().split(" ");
            int a[]=new int[sArr1.length];
            a[0]=Integer.parseInt(sArr1[0]);
            a[1]=Integer.parseInt(sArr1[1]);
            pq.offer(a);


        }
        while(!pq.isEmpty()){
            int a[]=pq.poll();

            if(s>a[0])s=s+a[1];
            else{
                flag=true;
                System.out.println("NO");
                break;
            }
        }

        if(!flag)
        System.out.println("YES");

         */



    }
}
