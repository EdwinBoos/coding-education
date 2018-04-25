/**
* 
* 
*
* Created by Edwin Boos ( 10.07.2017 )
* A Factory pattern implementation in JavaScript (ES6)
* 
* 
* 
* 
*/

String.prototype.equalsIgnoreCase = function(string) 
{
  
  return this.toUpperCase() === string.toUpperCase();
  
}

class CoffeeMachine
{

  brew() {};  
  
}

class CoffeeMachineFactory 
{
  
  createCoffeeType(coffeeType) 
  {
  
     if(coffeeType.equalsIgnoreCase("COFFEE"))
       return new Coffee();
     else if(coffeeType.equalsIgnoreCase("ESPRESSO"))
       return new Espresso();
     else return new NullObjectCoffeeMachine();  
    
  }
  
}

class Coffee extends CoffeeMachine
{
  
  brew() 
  {
    
    console.log("Brewing coffee")  
    
  }
  
}

class Espresso extends CoffeeMachine
{
  
  brew() 
  {
    
    console.log("Brewing espresso")  
    
  }
  
}


class NullObjectCoffeeMachine extends CoffeeMachine
{
  
  brew() 
  {
    
    console.log("Nothing to brew")  
    
  }
  
}


class Run {
  
  main( ) {
    
    const coffeeMachineFactory = new CoffeeMachineFactory();
    coffeeMachineFactory.createCoffeeType("coffee").brew();
    coffeeMachineFactory.createCoffeeType("espresso").brew();
    coffeeMachineFactory.createCoffeeType("somethingthatisnotexistant").brew();
    
    /**
	   * 
	   * The above code will print following text in the console : 
	   * -------------------------------------------------------------------------------------
	   *		
	   *                    Brewing Coffee				
	   *		        Brewing Espresso
	   * 		        Nothing to brew
	   *
	   * -------------------------------------------------------------------------------------
	   */  
  }
  
}

new Run().main();
