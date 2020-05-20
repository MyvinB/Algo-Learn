package SPOJ;/*
 @author Myvin Barboza
 20/05/20 5:59 PM 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DIEHARD {



    static int perform(int health,int armor,boolean[] check,int h[],int a[],int i){

      if(health+h[0]>0 && armor+a[0]>0 && check[0]) {

          check[0]=false;
          check[1]=true;
          check[2]=true;
          return 1+perform(health+h[0],armor+a[0],check,h,a,i+1);
      }
      else if(health+h[1]>0 && armor+a[1]>0 && check[1]) {
            check[1]=false;
            check[0]=true;
            check[2]=true;
            return 1+perform(health+h[1],armor+a[1],check,h,a,i+1);
      }
      else if(health+h[2]>0 && armor+a[2]>0 && check[2]) {
          check[2]=false;
          check[0]=true;
          check[1]=true;
          return 1+perform(health+h[2],armor+a[2],check,h,a,i+1);
      }
      return 0;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t--!=0){
            String s[]=br.readLine().split(" ");
            int h[]={3,-5,-20};
            int a[]={2,-10,5};
            boolean check[]={true,true,true};

            System.out.println(perform(Integer.parseInt(s[0]),Integer.parseInt(s[1]),check,h,a,0));


        }

    }
}