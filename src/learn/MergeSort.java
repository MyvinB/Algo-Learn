package learn;

import java.util.Arrays;

public class MergeSort{
    public static void main(String args[]){
        int a[] = {2,5,5,8,5,4};
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
        
    }

    public static void merge(int a[], int p , int q , int r) {
    	int n1 = q-p+1;
    	int n2 = r-q;
    	int L[] = new int[n1+1];
    	int R[] = new int[n2+1];
    	for(int i=0;i<n1;i++) {
    		L[i]= a[p+i];
    	}
    	for(int j=0;j<n2;j++) {
    		R[j]= a[q+j+1];
    	}
    	L[n1]=Integer.MAX_VALUE;
    	R[n2]=Integer.MAX_VALUE;
    	int i=0,j=0;
    	
    	for(int k=p;k<=r;k++) {
    		if(L[i]<=R[j]) {
    			a[k]=L[i];
    			i++;
    		}else {
    			a[k]=R[j];
    			j++;
    		}
    	}
    }
    public static void mergeSort(int a[] , int p , int r) {
    	int q=0;
    	if(p<r) {
    		q=(p+r)/2;
    	
        	mergeSort(a,p,q);
    		mergeSort(a,q+1,r);
    		merge(a,p,q,r);
    	}
    		
    }
}