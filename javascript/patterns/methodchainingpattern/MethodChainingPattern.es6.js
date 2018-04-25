/**
* 
* 
* A method Chaining Pattern implementation in JavaScript (ES6).
* 
*
*  
* Instead of writing (many statements):
*  
*
*     loggerInstance.addText("xd");
*     loggerInstance.addText("xd");
*     loggerInstance.newLine();
*     console.log(loggerInstance.getLoggedText());
* 
* 
* Write less code ( one statement )
*   
*  // We can chain functions that give us there current instance back.
*     console.log(
*            loggerInstance.addText("xd")
*            		   .addText("xd")
* 			   .newLine()
*                          .getLoggedText());	
* 
* 
* Created by Edwin Boos ( 26.08.2017 )
* 
*
*/
class Run {
  
  main () {
    
    	console.log(	
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

class Log {
	
	constructor() { this.loggedText = ""; }
	
	addText(text) { this.loggedText = this.loggedText + text; return this; }
	
	newLine() { this.loggedText = this.loggedText + "\n"; return this; }
	
	tab() { this.loggedText = this.loggedText + "\t"; return this; }
	
	getLoggedText() { return this.loggedText; }

}

new Run().main();
