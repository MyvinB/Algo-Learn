package LeetCode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class LongestSubstringWithoutRepeatingCharactersLC3 {
	
	// Sliding window technique solves the problem in n time complexity which would genrally take n3 or n2  complexitiy
	public static int SlidingWindow(String s) {
	       int n=s.length();
	    Map<Character,Integer> map=new HashMap<Character, Integer>();
	        int start=0;
	        int length=0;
	        for (int i = 0; i <n ; i++) {
	            char ch=s.charAt(i);
	            if(map.containsKey(ch)){
	                if(map.get(ch)>=start)
	                start=map.get(ch)+1;
	            }
	            length=Math.max(length,i-start+1);
	            map.put(ch,i);
	        }
	        return length;
	        
	 }
	//using bruteforce taking substrings and then validating them to see if they have repeating characters or not
	static List res=new ArrayList<String>();
	    
	
	
		static int getMax(List<String> t){
			int max=Integer.MIN_VALUE;
			for(String f:t){
				if(f.length()>max)max=f.length();
			}
			return max;
		}
		static void stringStore(String s){
	        res.add(s);

	    }
	    ///A check to see if the string has repeating characters
	    static boolean check(String s){
	    	Set<Character> a=new HashSet<>();
	    	for(int i=0;i<s.length();i++){
	    		if(a.contains(s.charAt(i)))return false;
	    		else a.add(s.charAt(i));
	    	}
	    	return true;
	    }
	    //recursion method to get all permutations of a string
	    static void printSubString(String s){
	    
	    	for (int i = 0; i < s.length(); i++) {
				for (int j = i+1; j <=s.length(); j++) {
					
					if(check(s.substring(i,j))){
						stringStore(s.substring(i,j));
					}
				}
			}
	    }

	
	
	public static void main(String[] args) {
		String s="abcabcbcbb";
		long start = System.nanoTime(); 
		System.out.println(SlidingWindow(s));
        long end = System.nanoTime(); 
        System.out.println("Sliding window takes " + 
                                    (end - start) + "nano time"); 
        
        start = System.nanoTime(); 
        printSubString(s);
        System.out.println(getMax(res));
        end = System.nanoTime(); 
        System.out.println("Bruteforce approach takes " + 
                                    (end - start) + "nano time");
		
	}
	
	
}
