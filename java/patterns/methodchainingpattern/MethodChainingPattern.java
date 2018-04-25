package org.jsweet;

import static def.dom.Globals.*;

/**
* 
* 
* A method Chaining Pattern implementation in Java.
* 
*
*  
* Instead of writing (many statements):
*  
*
*     loggerInstance.addText("xd");
*     loggerInstance.addText("xd");
*     loggerInstance.newLine();
*     System.out.println(loggerInstance.getLoggedText());
* 
* 
* Write less code ( one statement )
*   
* // We can chain functions that give us there current instance back.
*     System.out.println(
*            loggerInstance.addText("xd")
*            		   .addText("xd")
* 			   .newLine()
*                          .getLoggedText());	
* 
* 
* Created by Edwin Boos ( 26.08.2017 )
* with Jsweet see : http://www.jsweet.org/jsweet-live-sandbox/ 
* 
*
*/
public class Run {
	
	public static void main(String[] args) {
		
		System.out.println(
			
			new Log().addText("method chaining pattern demo")
					 .newLine()
					 .addText(" ---------------------------- ")
					 .newLine()
					 .addText("Text after second line") 
					 .newLine()
					 .addText("first part between tab")
					 .tab()
					 .addText("second part between tab")
					 .getLoggedText());
		
	    /**
	     * 
	     * The above code will print following text in the console : 
	     * -------------------------------------------------------------------------------------
	     *		
	     * 			method chaining pattern demo
 	     *			---------------------------- 
	     *			Text after second line
	     *			first part between tab	second part between tab
	     *
	     * -------------------------------------------------------------------------------------
	     */  
		
	}
} 

public final class Log {
	
	private String loggedText = "";
	
	public Log() { }
	
	public Log addText(String text) { this.loggedText = this.loggedText + text; return this; }
	
	public Log newLine() { this.loggedText = this.loggedText + "\n"; return this; }
	
	public Log tab() { this.loggedText = this.loggedText + "\t"; return this; }
	
	public String getLoggedText() { return this.loggedText; }

}
