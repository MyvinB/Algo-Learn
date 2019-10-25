import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {

//		int a[]=new int[] {2,1,6,3,5};
//		int key;
//		int j;
//		for(int i=1;i<a.length;i++){
//			key=a[i];
//			j=i-1;
//			while(j>=0&&a[j]>key) {
//			
//				a[j+1]=a[j];
//				j=j-1;
//			}
//			a[j+1]=key;
//		}
//		for(int i=0;i<5;i++)
//		System.out.println(a[i]);
//		
		int n=5; 
		for(int j=n-1;j>=0;j--){
	          for(int i=0;i<n;i++){
	              if(i<j) {
	            	  System.out.printf(" ");
	              }
	              else
	             System.out.printf("#");
	        }
	         if(j==0)break;
	        System.out.println();
	        }
		
		
		System.out.printf("tana");
		
		
//		 for(int j=0;j<n;j++){
//             for(int i=0;i<n;i++){
//                 if(i<=j){
//               System.out.print("#");
//                 }else{
//                     System.out.print(" ");
//                 }
//                 
//           }
		
	
		
		
	}
}
