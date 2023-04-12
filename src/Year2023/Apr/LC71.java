package Year2023.Apr;

import java.util.Stack;

public class LC71 {

    public static void main(String[] args) {

    }

    public String simplifyPath(String path) {
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
