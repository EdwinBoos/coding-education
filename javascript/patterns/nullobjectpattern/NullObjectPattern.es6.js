/**
* 
* 
* This example shows a NullObject-Pattern Example in JavaScript (ES6)
* Created by Edwin Boos ( 13.04.2017 )
* 
* The example is based on Daniel Dumile as the Superclass and with his alternative ego's
* MF-DOOM and Madvillain as the sub classes.
* See: https://de.wikipedia.org/wiki/Daniel_Dumile
* 
* 
*/
class DanielDumile 
{
	
  constructor() {}
  spitSomeFire() {  }

}

 
class DanielDumileNullObject extends DanielDumile 
{

    constructor() { super(); }
    spitSomeFire() { console.log("SORRY NOTHING FOUND!"); }  // Polymorphy

}


class MFDOOM extends DanielDumile 
{

    constructor() { super(); }
    spitSomeFire() { console.log("MFDOOM - Doomsday"); } // Polymorphy, as well ._.

}


class MadVillain extends DanielDumile 
{

    constructor() { super(); }
    spitSomeFire() { console.log("MadVillain - All Caps"); }   // Polymorphy, as well, as well ._.

}


class Pool
{

  constructor() { this.pool = []; }
	
  jumpIntoPool(key, object) { this.pool.push({key, object}); return this };  
  getOutOfPool(key) {
  
	  if(this._isInPool(key)) 
	  {
	     for(let x = 0; x < this.pool.length; x++) {
	       
		       if(key === this.pool[x].key) { return this.pool[x].object; } 
	     }  
	  } else return new DanielDumileNullObject(); 
  }


   _isInPool(key) {
    
    let isInPool = false;

	 for(let x = 0; x < this.pool.length; x++) {
	     if(this.pool[x].key === key) {
		       isInPool = true;
		       break;
	     }
	  }
	    return isInPool;     
   }
   
}


const poolIds = 
{
       
    mfDoomPoolId : "MFDOOM",
    madVillainPoolId : "MADVILLAIN", 
        
}


class Run  
{

  constructor() {}
  
  main() {
  
    // Create a new Instance of Pool, and add objects with Id's into the pool.	  
    const pool = new Pool();
    pool.jumpIntoPool(poolIds.mfDoomPoolId, new MFDOOM())  
        .jumpIntoPool(poolIds.madVillainPoolId, new MadVillain());
        
    // We can easily access the methods spitSomeFire, because "getOutOfPool" will return for the provided ids, real objects.
    // But what if i would pull something out of the Pool that is not existant? Yep it would crash the Program, 
    // because i would get a "null" here. Easy as that. 
    // The first solution here, is to ask everytime if the return value is null or not, and then call the function.
    // This could mess the code up if you have to call the function "getOutOfPool"  multiple times.	
    // The Second and better solution (NullObject-Pattern): I optimized the "getOutOfPool" Method, to create and return a DanielDumileNullObject, 
    // when nothing was found in the pool.
    // Please see the class DanielDumileNullObject which contains a spitSomeFire() method in it, it will log "SORRY, NOTHING FOUND!", wenn called.
    // By this way, we will always get a Object from the method back, which in our case will not crash our program.
    pool.getOutOfPool(poolIds.mfDoomPoolId).spitSomeFire(); 
    pool.getOutOfPool(poolIds.madVillainPoolId).spitSomeFire();   
	  
    // Okay, lets try the "optimized" method.
    // Since the Id "3" is not added to the pool, the method getOutOfPool() returns a Null Object Pattern.	  
   pool.getOutOfPool("somethingthatisnotadded").spitSomeFire();   
    
    /**
	  * Will print in the console:
		*	run:63 MF-DOOM - Doomsday
		*	run:87 MadVillain - ALL CAPS
		*	run:75 SORRY, NOTHING FOUND!
		*/	  
    
  }
  
}

new Run().main(); 
