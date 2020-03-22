package TestHackerEarth;

/*
 @author Myvin Barboza
 21/03/20 5:28 PM 
 */public class MLS {

     static int rahul(int a[]){
         int sum=0;
         int len=Integer.MAX_VALUE;
         for (int i = 0; i <a.length ; i++) {
             sum=sum+a[i];
             for (int j = i+1; j <a.length ; j++) {
                 sum=sum+a[j];
                 if(sum%14==0){
                         len=Math.min(len,j-i+1);
                 }
             }
             sum=0;

         }
         return len;

     }

    public static void main(String[] args) {
         int ankita[]={3,4,7,2,1,6,2};
          int ankita2[]={7,4,1,2,2,9,8,9};
        System.out.println(rahul(ankita2));
    }
}