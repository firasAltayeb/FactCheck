package app;

import java.util.ArrayList;

public class Concatenate {
	
	public ArrayList<String> stringList = new ArrayList<>(); 

    public String concatenate(String one, String two){
        return one + two;
    }
    
    public int addNumbers(int a, int b) {
    	return a+b;
    }
    
    public int multiplyNumbers(int a, int b)
    {
    	if (a == 0 | b == 0) {
    		return 0;
    	}    
    	return a*b;
    }
}