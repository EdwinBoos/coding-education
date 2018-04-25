package de.fis.influenz;
import static def.dom.Globals.*;
import java.util.HashMap;

/**
*
*
* ProxyPattern Example in Java
* Created by Edwin Boos ( 15.08.2017 )
* with Jsweet see : http://www.jsweet.org/jsweet-live-sandbox/ 
*
* The Proxy-Pattern helps you to gain massive performance, when a big list should be searched,
* with the same text multiple times.
*
* Lets look at the classes Storage and Proxy: They both have a search Method,
* the Storage class does call internally the Proxy's search method which returns its searched result.	
* 
* The Proxy Class has a cache (which is a HashMap based on searchTerm as Key, and the matchedFile as Value)
* it also knows about all fileNames, which is passed by the Storage class by constructor.
*
* The Proxy Class will save every successful search in a local hashmap, by looping trough
* a big list, which is really slow. When the search method will be called again with
* the same searchText, we will not loop trough the whole list again, instead we will gain
* performance by searching in the hashmap, in which we added the entry last time and we will
* return it.
* 
*/
public class Run 
 {
	
	public static void main(String[] args) 
	{	
		
		final Storage storage = new Storage();
		
		storage.search("FILE H"); // the first search will be slow, because we need to loop the big list completely to find our file
		storage.search("FILE H"); // the second search will be fast, because "FILE H" exists in the cache.
		storage.search("FILE H"); // Nothing changes here to 2) will be fast aswell.
 		storage.search("FILE A"); // same as 1) it is not cached
		
	  /**
	   * 
	   * The above code will print following text in the console : 
	   * -------------------------------------------------------------------------------------
	   *		
	   *          We couldnt find the file in the cache, but we could find it in the whole array, which is very slow. 
	   *	      Since we could find the matchedFile we need to add the searchTerm and the matched File to the cache.
           *          We found the File H in the cache, which is much faster.
           *          We found the File H in the cache, which is much faster.	
           *          We couldnt find the file in the cache, but we could find it in the whole array, which is very slow. 
           *          Since we could find the matchedFile we need to add the searchTerm and the matched File to the cache.
	   *
	   * -------------------------------------------------------------------------------------
	   */  
		
	}
	
} 


public class Proxy {

	private HashMap <String, String> cache = new HashMap();
	
	private final String[] files;
	
	public Proxy(String[] files) 
	{
		this.files = files;
	}

	public String search(String searchTerm) 
	{
		
		 String matchedFile;
		 matchedFile = this.cache.get(searchTerm);
	
		if(matchedFile != null) 
		{
			// We found the file with the searchTerm, in our local cache.
			// just immediately return the matchedFile in a performant manner.
		   	System.out.println("We found the " + matchedFile + " in the cache, which is much faster.");
			return matchedFile;		
		}
		else 
		{
			// We couldn't find the searchTerm in the local cache.
			// Now we need to search it in the original File list, in a inperformant manner ( with a for loop trough whole file list ).
			for(String file : this.files) {
				
				if(searchTerm.equalsIgnoreCase(file)) {
					
					System.out.println("We couldnt find the file in the cache, but we could find it in the whole array, which is very slow. ");
					System.out.println("Since we could find the matchedFile we need to add the searchTerm and the matched File to the cache.");

					matchedFile = file;
					this.cache.put(searchTerm, matchedFile);

				}
			}
		}
		
		return matchedFile;
	}
	
}


public class Storage {
	
	private final Proxy proxy;
	
	private String[] files = {
		 					   "File 1", "File 2", "File 3", "File 4", "File 5", "File 6",
							   "File 7", "File 8", "File 9", "File 0", "File A", "File B",
							   "File C", "File D", "File E", "File F", "File G", "File H"
							 };
	
	public Storage() 
	{
		this.proxy = new Proxy(files);
	}
	
	public String search(String searchTerm) 
	{	
		return this.proxy.search(searchTerm);
	}

}
