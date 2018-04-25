/**
*
*
* The Intent of a NullObject is to never check for null values when a result is returned from a method. 
* ( For deeper understanding, see the main method there is a explanation ).
* 
* NullObjectPattern Example:
* Created by Edwin Boos ( 11.04.2017 )
* with Jsweet see : http://www.jsweet.org/jsweet-live-sandbox/ 
* The example is based on Daniel Dumile as the Superclass and with his alternative ego's
* MF-DOOM and Madvillain as the sub classes.
* See: https://de.wikipedia.org/wiki/Daniel_Dumile
* 
* 
*/

package org.jsweet;

import static jsweet.dom.Globals.*;
import java.util.HashMap;


public class Pool extends HashMap <String, DanielDumile> 
{
	
	public Pool() {}
	
	public Pool jumpIntoPool(String key, DanielDumile object) { super.put(key, object); return this; }
	
	public DanielDumile getOutOfPool(String key) {
		
		if(this.isInPool(key)) return (DanielDumile) super.get(key);
		else return new DanielDumileNullObject();
		
	}
	
	private boolean isInPool(String key) { return super.get(key) != null ? true : false; }
	
}


public abstract class DanielDumile { 

	public DanielDumile() { }	
	public abstract void spitSomeFire();
	
}


public class MFDOOM extends DanielDumile { 

	public MFDOOM() { super(); }	
	public void spitSomeFire() { System.out.println("MF-DOOM - Doomsday"); } // Polymorphy
	
}


public class DanielDumileNullObject extends DanielDumile {
	
    public DanielDumileNullObject() { super(); }
	public void spitSomeFire()  { System.out.println("SORRY, NOTHING FOUND!"); } // Polymorphy, as well ._.

}


public class MadVillain extends DanielDumile { 

	public MadVillain() { super(); }	
	public void spitSomeFire() { System.out.println("MadVillain - ALL CAPS"); } // Polymorphy, as well, as well ._.
	
}


interface PoolIds {

	public final String MF_DOOM_POOL_ID = "MFDOOM";
	public final String MAD_VILLAIN_POOL_ID = "MADVILLAIN";
	
}


public class Run implements PoolIds {
	
	public static void main(String[] args) {
		
		
		// Create a new Instance of Pool, and add objects with Id's into the pool.
		final Pool pool = new Pool();
		pool.jumpIntoPool(MF_DOOM_POOL_ID, new MFDOOM())
		    .jumpIntoPool(MAD_VILLAIN_POOL_ID, new MadVillain());
	
		// We can easily access the methods spitSomeFire, because "getOutOfPool" will return for the provided ids, real objects.
		// But what if i would pull something out of the Pool that is not existant? Yep it would crash the Program, 
		// because i would get a "null" here. Easy as that. 
		// The first solution here, is to ask everytime if the return value is null or not, and then call the function.
		// This could mess the code up if you have to call the function "getOutOfPool"  multiple times.	
		// The Second and better solution (NullObject-Pattern): I optimized the "getOutOfPool" Method, to create and return a DanielDumileNullObject, 
		// when nothing was found in the pool.
		// Please see the class DanielDumileNullObject which contains a spitSomeFire() method in it, it will log "SORRY, NOTHING FOUND!", wenn called.
		// By this way, we will always get a Object from the method back, which in our case will not crash our program.
		pool.getOutOfPool(MF_DOOM_POOL_ID).spitSomeFire();
		pool.getOutOfPool(MAD_VILLAIN_POOL_ID).spitSomeFire();
		
		// Okay, lets try the "optimized" method.
		// Since the Id "3" is not added to the pool, the method getOutOfPool() returns a Null Object Pattern.
		pool.getOutOfPool("somethingthatisnotadded").spitSomeFire();
		
	       /**
	        *   Will print in the console:
		*	run:63 MF-DOOM - Doomsday
		*	run:87 MadVillain - ALL CAPS
		*	run:75 SORRY, NOTHING FOUND!
		*/
	}
}
