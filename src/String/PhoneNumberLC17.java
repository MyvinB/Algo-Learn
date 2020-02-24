package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneNumberLC17 {

	static HashMap<Integer,String> map=new HashMap<Integer,String>();
	static{
		map.put(2,"abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		
	}
	
	//recursion takes exponential time in this case
	static List<String> phone(String ques,String res,List<String> list){
		
		if(ques.isEmpty()){
		
		list.add(res);
		
		return list;
	}
	
	String sa=map.get(Integer.parseInt(ques.substring(0,1)));
	

	for(int i=0;i<sa.length();i++){
		char ch=sa.charAt(i);
		phone(ques.substring(1),res+ch,list);
	}
	return list;

}
	
	static List<String> letterCombinations(String digits) {
        List<String> answer=new ArrayList<String>();
  if(digits.equals(""))return answer;
  answer.add("");
  char [][]dp = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
  for (int i = 0; i <digits.length() ; i++) {
      char ch=digits.charAt(i);
      ArrayList<String> temp=new ArrayList<String>();
      for(String a:answer){
          for(char c:dp[ch-'0']){
              temp.add(a+c);
          }
      }
      answer=temp;
  }
  return answer;  
}
	
public static void main(String[] args) {
	String s="234";
	long start = System.nanoTime(); 
	List<String> list=phone(s,"",new ArrayList<String>());
	System.out.println(list);
    long end = System.nanoTime(); 
    System.out.println("Recursion" + 
                                (end - start) + "nano time"); 
    
    start = System.nanoTime(); 
    System.out.println(letterCombinations("233"));
  
    end = System.nanoTime(); 
    System.out.println("Iterative way" + 
                                (end - start) + "nano time");
	
	
	

	
}
}
