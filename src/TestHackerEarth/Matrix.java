package TestHackerEarth;

/*
 @author Myvin Barboza
 21/03/20 4:59 PM 
 */public class Matrix {

     static int countMatrix(char a[][], int k){
         int count=0;
         int max=0;
         for (int i = 0; i <a.length ; i++) {
             for (int j = 0; j <a[i].length ; j++) {
                 int p=i,q=j;
                 while(p<a.length&&p<i+k){
                     while(q<a.length &&q<j+k) {
                         if (a[p][q] == '*') count++;
                         q++;
                     }
                     q=0;
                     p++;
                 }

                 if(count>max)max=count;
                 count=0;
             }
         }
         return max;
     }

     public static void main(String[] args) {
         char a[][] ={{'*','M','*'},{'*','*','k'},{'*','L','Z'}};
         System.out.println(countMatrix(a,2));
    }
}