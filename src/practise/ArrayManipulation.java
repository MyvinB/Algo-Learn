package practise;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

    public class ArrayManipulation {

        // Complete the arrayManipulation function below.
        static long  arrayManipulation(int n, int[][] queries) {
            int[] a =new int[n+1];
            for(int i=0;i<queries.length;i++){
                  for(int e=1;e<(n+1);e++) {
                      System.out.println(e + " * " + queries[i][0] + "   " + queries[i][1]);
                      if (e >= queries[i][0] && e <= queries[i][1]) {

                          a[e] = a[e] + queries[i][2];
                      }
                  }
                    System.out.println(Arrays.toString(a));
            }
            Arrays.sort(a);

            return a[n];



        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {

            int n=5;
            int[][] queries = new int[][] {
                    new int[] { 1, 2, 100 },
                    new int[] { 2,5,100},
                    new int[] { 3,4,100}
            };

            arrayManipulation(n, queries);





        }
    }


