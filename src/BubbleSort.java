import java.util.Arrays;

public class BubbleSort {

	

	
public static void main(String args[]){
	System.out.println("Thank you for working");
	int[] a={4,2,6,8,10,9,3};
	int n=a.length;
	for (int i = 0; i < n-1; i++) {
		for(int j=0;j<n-i-1;j++){
			if(a[j]>a[j+1]){
				int temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
				
			}
		}
		System.out.println(Arrays.toString(a)+" for "+i);
	}
	System.out.println(Arrays.toString(a));
}


}
