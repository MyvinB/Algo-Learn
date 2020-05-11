package CodeForce.A;
/*
 @author Myvin Barboza
 10/05/20 6:34 PM 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A118StringTask {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        StringBuilder sb=new StringBuilder();
        Set<String> set =  new HashSet<>(Arrays.asList("A", "O", "Y", "E", "U", "I"));


        for (int i = 0; i <s.length() ; i++) {
            if(!set.contains(String.valueOf(s.charAt(i)).toUpperCase())){
                sb.append(".");
                sb.append(String.valueOf(s.charAt(i)).toLowerCase());
            }
        }

        System.out.println(sb.toString());

    }
}