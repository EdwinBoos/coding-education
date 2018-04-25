package org.jsweet;

import static jsweet.dom.Globals.*;

/**
* 
* 
* A Singleton Pattern implementation in Java.
*
* It is considered as a anti-pattern by many people in the web:
* So be careful because is not thread-safe, which means when you call the 
* getInstance Method on different threads, it will always create new instances.
*       
*      
* 
* 
* 
* Created by Edwin Boos ( 10.07.2017 )
* with Jsweet see : http://www.jsweet.org/jsweet-live-sandbox/ 
* 
*
*/
public class Run 
{
	
	public static void main(String[] args) 
	{
	
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		
		// Will log in the console : Is it the same instance? true
		System.out.println("Is it the same instance? " + ( singleton1 == singleton2 ));
		
	}
	
}

public static class Singleton 
{

	private static Singleton instance = null;
	
	private Singleton() { }
	
	public static Singleton getInstance() 
	{
	
		if(instance == null) 
		{
			instance = new Singleton();	
		}
		
		return instance;
		
	} 

}
