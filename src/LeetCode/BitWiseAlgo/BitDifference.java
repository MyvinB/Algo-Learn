package LeetCode.BitWiseAlgo;/*You are given two numbers A and B. Write a program to count number of bits needed to be flipped to convert A to B.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. The first line of each test case is A and B separated by a space.

Output:
For each testcase, in a new line, print the number of bits needed to be flipped.

Constraints:
1 ≤ T ≤ 100
1 ≤ A, B ≤ 103

Example:
Input:
1
10 20
Output:
4

Explanation:
Testcase1:
A  = 01010
B  = 10100
Number of bits need to flipped = 4
 */
import java.util.Scanner;

public class BitDifference
{
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	while(t!=0){
		int a=sc.nextInt();
		int b=sc.nextInt();
		String s1=Integer.toString(a,2);
		String s2=Integer.toString(b,2);
		for(int i=0;i<16;i++){
			if(s1.length()!=16){
				s1='0'+s1;
			}
			if(s2.length()!=16){
				s2='0'+s2;
			}
		}
		int count=0;
		for(int i=0;i<16;i++){
			if(s1.charAt(i)!=s2.charAt(i))count++;
		}
		System.out.println(count);
		t--;
	}
}
}
