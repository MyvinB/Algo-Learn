import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 @author Myvin Barboza
 14/04/20 10:42 AM 
 */
public class SimplifyPathLC71 {

    static String simplifyPath(String path) {
    Stack<String> stack=new Stack<>();

   for(String dir:path.split("/")){
       if(dir.equals("..") && !stack.isEmpty()) stack.pop();
       else if(!dir.equals("..")&& !dir.equals(".")&& !dir.equals("") ) stack.push(dir);
   }

       StringBuilder res=new StringBuilder();
    for(String s:stack){
        res.append("/");
        res.append(s);
    }
    return res.toString().isEmpty()? "/":res.toString();




    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }
}