package org.jsweet;

import static jsweet.dom.Globals.*;

/**
* 
* 
* A Factory Pattern implementation in Java.
* 
* 
* 
* Created by Edwin Boos ( 10.07.2017 )
* with Jsweet see : http://www.jsweet.org/jsweet-live-sandbox/ 
* 
*
*/
public class Run implements FactoryWrapper
{
	
	public static void main(String[] args) 
	{
	

	    CoffeeMachineFactory coffeeMachineFactory = new CoffeeMachineFactory();
	    coffeeMachineFactory.createCoffeeType("coffee").brew();
	    coffeeMachineFactory.createCoffeeType("espresso").brew();
	    coffeeMachineFactory.createCoffeeType("somethingthatnotexistant").brew();
		
	  /**
	   * 
	   * The above code will print following text in the console : 
	   * -------------------------------------------------------------------------------------
	   *		
	   *            Brewing Coffee				
	   *		Brewing Espresso
	   * 		Nothing to brew
	   *
	   * -------------------------------------------------------------------------------------
	   */  
		
	}
	
}

public interface FactoryWrapper
{
	
	public interface CoffeeMachine
	{
	
		public void brew();
		
	}
	
	public class CoffeeMachineFactory  
	{

		public CoffeeMachine createCoffeeType(String coffeeType) 
		{
			
			if(coffeeType.equalsIgnoreCase("COFFEE")) 
			{
					return new Coffee();
			}
			else if(coffeeType.equalsIgnoreCase("ESPRESSO")) 
			{
					return new Espresso();
			}
			else return new NullObjectCoffeeMachine();
				
		}
		
	}
	
	public class Coffee implements CoffeeMachine
	{
		
		public void brew() 
		{
		
			System.out.println("Brewing Coffee");
			
		}
		
	}
	
	public class Espresso implements CoffeeMachine
	{
		
		public void brew() 
		{
		
			System.out.println("Brewing Espresso");
			
		}
		
	}	

	public class NullObjectCoffeeMachine implements CoffeeMachine
	{
		
		public void brew() 
		{
		
			System.out.println("Nothing to brew");
			
		}
		
	}	
	
}
