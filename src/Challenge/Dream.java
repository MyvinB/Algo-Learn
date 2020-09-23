package Challenge;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Dream{


    public static void main(String[] args) throws IOException {

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)a[i]=sc.nextInt();
            int m=sc.nextInt();
            int b[]=new int[m];
            for(int i=0;i<m;i++)b[i]=sc.nextInt();
            int i=0,j=0,count=0;
            Arrays.sort(a);Arrays.sort(b);
            while(i < n && j <m )
            {
                if(Math.abs(a[i] - b[j]) <= 1) // if height difference is less than K, answer increases.
                {
                    i++;
                    j++;
                    count++;
                }
                else if(a[i] < b[j])
                    i++;
                else
                    j++;
            }
            System.out.println(count);
        }


    }
}