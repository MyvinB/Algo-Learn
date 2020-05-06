package Math;

/*
 @author Myvin Barboza
 28/04/20 12:11 PM 
 */public class PowerLC50 {

   static double myPow(double x, int n) {
      if(n==0) return 1;
      double half=myPow(x,n/2);
      if(n%2==0){
          return half*half;
      }
      else if(n<0){
          return 1/x* half * half;
      }
      else return x * half * half;


    }


     public static void main(String[] args) {
         System.out.println(myPow(2,-2));
    }
}