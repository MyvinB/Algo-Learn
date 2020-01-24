/*Input:
The first line of the input contains T denoting the number of testcases. First line of each test case contains two space separated elements, N denoting the size of the array and an integer D denoting the number size of the rotation. Subsequent line will be the N space separated array elements.

Output: 
For each testcase, in a new line, output the rotated array.

Constraints:
1 <= T <= 200
1 <= N <= 107
1 <= D <= N
0 <= arr[i] <= 105

Example:
Input:
2
5 2
1 2 3 4 5 
10 3
2 4 6 8 10 12 14 16 18 20

Output:
3 4 5 1 2
8 10 12 14 16 18 20 2 4 6*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayRotation {
	public static void main(String[] args) {
	
	   try {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           int t = Integer.parseInt(br.readLine());
           while(0<t){
        	  String s=br.readLine();
        	  String s1[]=s.split(" ");
        	  int n=Integer.valueOf(s1[0]);
        	  int k=Integer.valueOf(s1[1]);
        	  int a[]=new int[n];
        	  String s2=br.readLine();
        	  String s2s[]=s2.split(" ");
        	  for(int i=0;i<n;i++){
        		  a[i]=Integer.valueOf(s2s[i]);
        	  }
        	  int temp=0;
        	  int count=0;
        	  for(int i=k-1;i>=0;i--){
        			int j=i;
        			while(j<(a.length-1-count)){
        				
        			temp=a[j];
        			a[j]=a[j+1];
        			a[j+1]=temp;
        			j++;
        			}
        			count++;
        		}
        	  for (int  i : a) {
				System.out.print(i+" ");
        	  }
        	  t--;
           }
       } catch (Exception e) {
           // e.printStackTrace();
       }

	
}
}
