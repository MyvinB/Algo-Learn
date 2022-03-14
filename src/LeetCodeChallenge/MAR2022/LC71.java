package LeetCodeChallenge.MAR2022;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 6:10 AM 3/14/2022
 * Time Taken:
 */
public class LC71 {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home//foo/"));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for(String dir :path.split("/")){
            if(dir.equals("..") && !stack.isEmpty()) stack.pop();
            if(!dir.equals("..") && !dir.equals(".") && !dir.equals("")) stack.push(dir);
        }
        StringBuilder sb = new StringBuilder();
        for(String s:stack){
            sb.append("/");
            sb.append(s);
        }
        return sb.toString().isEmpty()?"/":sb.toString();
    }
}
