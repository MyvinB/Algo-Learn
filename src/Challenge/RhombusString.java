package Challenge;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 @author Myvin Barboza
 09/05/20 5:22 PM
 Question:
 Spiral Rhombus Pattern

Given half-height h, and a string s output a rhombus pattern with a spiral in it formed using the characters in the string. Direction of the spiral is clockwise inward.
Input Format
The first line of input consists of an integer t which is the number of test cases. First line of each test case consists of two space separated integers, h and l denoting the half-height of the rhombus and length of the string respectively. Second line is the string s.
Output Format
For every test case, print the spiral rhombus pattern (see diagrams below).
Sample Input
5
3 26
abcdefghijklmnopqrstuvwxyz
4 5
12345
5 2
01
6 6
spiral
2 1
z
Sample Output
  c
 bjd
aimke
 hlf
  g
   4
  355
 24211
1315322
 25433
  144
   5
    0
   111
  00000
 1111111
000000000
 1111111
  00000
   111
    0
     l
    ass
   rlrpp
  iaiiaii
 prpprrlrr
sissisaasaa
 pllpllpll
  saasiss
   lrrpp
    aii
     r
 z
zzz
 z
Constraints
1 <= t <= 1000
1 <= h <= 1000
1 <= l <= 1000
Character set of s - 0-9a-z

 */

public class RhombusString {




    public static void main(String[] args) throws IOException {
      //  int n=3;
        //String s="abcdefghijklmnopqrstuvwxyz";
        
        int space=0;
       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t--!=0){
            String s1[]=br.readLine().split(" ");
            int n=Integer.parseInt(s1[0]);
            int length=Integer.parseInt(s1[1]);
            String s=br.readLine();
            char a[][]=new char[2*n-1][2*n-1];
            int mid=n-1;
            int q=0;
            int col=0;
            int colEnd=2*n-2;
            int row=0;
            int rowEnd=2*n-2;
            while(row<=rowEnd && col<=colEnd) {

                for (int i = n - 1, j = col; i >= row && j <= mid; i--, j++) {
                    if(q>=s.length()) q=0;
                    a[i][j] = s.charAt(q);
                    q++;
                }


                for (int i = row + 1, j = mid+ 1; i < n && j <= colEnd; i++, j++) {
                    if(q>=s.length()) q=0;
                    a[i][j] = s.charAt(q);

                    q++;
                }

                for (int i = n, j = colEnd - 1; i <= rowEnd && j >= mid; i++, j--) {
                    if(q>=s.length()) q=0;
                    a[i][j] = s.charAt(q);
                    q++;
                }


                for (int i = rowEnd - 1, j = mid - 1; i >= n && j > col; i--, j--) {
                    if(q>=s.length()) q=0;
                    a[i][j] = s.charAt(q);
                    q++;
                }
                row++;
                rowEnd--;
                col++;
                colEnd--;

            }
            for (int i = 0; i <a.length ; i++) {
                for (int j = 0; j <a[i].length ; j++) {
                    if(a[i][j]=='\0') System.out.print(" ");
                    else
                    System.out.print(a[i][j]);
                }
                System.out.println();
            }


        }




        }







    }