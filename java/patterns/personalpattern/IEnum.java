/**
* 
* 
* An example for storing 'enum' like constants that belong together in only one Interface, by 
* defining classes in the IEnum Interface.
* 
* 
* 
* Created by Edwin Boos ( 01.06.2017 )
* with Jsweet see : http://www.jsweet.org/jsweet-live-sandbox/ 
* 
*
*/
package org.jsweet;
import static jsweet.dom.Globals.*;


public final class Run implements IEnum {
	
	public static void main(String[] args) {
		
		System.out.println(EnumCar.VW);
		System.out.println(EnumCar.AUDI);
		System.out.println(EnumColor.BLACK);
		System.out.println(EnumColor.WHITE); 
											
	}
}


interface IEnum {
	
	public final class EnumCar implements IEnum {
		
		public final static String VW = "VW";
		public final static String AUDI = "AUDI";
		
	}
	
	public final class EnumColor implements IEnum {
		
		public final static String BLACK = "schwarz";
		public final static String WHITE = "weiss";
		
	}
	
}
