import java.util.Stack;

public class ValidParenthesisLC20 {
	static boolean isValid(String s) {
        char a[]={'{','}','(',')','[',']'};
        Stack<Character> stack=new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char ch=s.charAt(i);
        	for (int j = 0; j < a.length; j++) {
				if(ch==a[j]){
					
					if(j%2==0)stack.push(a[j+1]);
					else if(stack.pop()!=ch)return false;
				}
			}
		}
		if(!stack.isEmpty())return false;
		return true;
      
    }
	
		public static void main(String[] args) {
			System.out.println(isValid("{[]}"));
		}
}
