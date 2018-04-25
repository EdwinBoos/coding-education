/**
* 
* 
*
* Created by Edwin Boos ( 10.07.2017 )
* A Singleton pattern implementation in JavaScript (ES6)
* 
* 
* 
* 
*/
class Singleton 
{
  
  static instance = null;
  
  static getInstance() 
  {
    
    if(!Singleton.instance) 
    {
      
      Singleton.instance = new Singleton();
      
    }
    
    return Singleton.instance;
    
  }
  
}

class Run {
  
  main( ) {
    
    
      const singleton1 = Singleton.getInstance();
      const singleton2 = Singleton.getInstance();
    
      // Will print in the console: Is it the same instance? true
      console.log("Is it the same instance? " + ( singleton1 === singleton2 ))
  }
  
}

new Run().main();
