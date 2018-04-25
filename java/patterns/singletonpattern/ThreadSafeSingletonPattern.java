package org.jsweet;

import static jsweet.dom.Globals.*;

/**
* 
* 
* A Thread-Safe Singleton Pattern implementation in Java.
*
*
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
	
		ThreadSafeSingleton singleton1 = ThreadSafeSingleton.getInstance();
		ThreadSafeSingleton singleton2 = ThreadSafeSingleton.getInstance();
		
		// Will log in the console : Is it the same instance? true
		System.out.println("Is it the same instance? " + ( singleton1 == singleton2 ));
		
	}
	
}


 
public class ThreadSafeSingleton 
{
 
	private static ThreadSafeSingleton instance = null;
 
	private ThreadSafeSingleton() {}
 
	public static ThreadSafeSingleton getInstance() 
	{
		
		if (instance == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeSingleton();
				}
			}
		}
		return instance;
		
	}
	
}
