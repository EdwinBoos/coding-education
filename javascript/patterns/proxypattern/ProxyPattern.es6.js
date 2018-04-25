/**
*
*
* ProxyPattern Example in JavaScript (ES6)
* Created by Edwin Boos ( 15.08.2017 )
*  
*
* The Proxy-Pattern helps you to gain massive performance, when a big list should be searched,
* with the same text multiple times.
*
* Lets look at the classes Storage and Proxy: They both have a search Method,
* the Storage class does call internally the Proxy's search method which returns its searched result.	* 
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
String.prototype.equalsIgnoreCase = function(string) 
{
  
  return this.toUpperCase() === string.toUpperCase();  
	
}

class Run {
  
  main( ) {
    
    const storage = new Storage();
    
    storage.search("FILE H"); // the first search will be slow, because we need to loop the big list completely to find our file
    storage.search("FILE H"); // the second search will be fast, because "FILE H" exists in the cache.
    storage.search("FILE H"); // Nothing changes here to 2) will be fast aswell.
    storage.search("FILE A"); // same as 1) it is not cached    
  }
  
}

class Proxy
{
  
   constructor(files)
   {
     if(!this.cache)
       this.cache = [];
       
       this.files = files;
   }
  
  search(searchTerm) {
   
      var matchedFile = "";
   
      if(this.cache.length > 0) 
      {
        for(let x = 0; x < this.cache.length; x ++)
        {
           if(this.cache[x].key === searchTerm) {
              // We found the file with the searchTerm, in our local cache.
              matchedFile = this.cache[x].value;
              console.log("We found the " + matchedFile + " in the cache, which is much faster.")
             
           }
        }
      
      }
      else {
        for(let x = 0; x < this.files.length; x ++) {
          
         
          // We couldn't find the searchTerm in the local cache.
	  // Now we need to search it in the original File list, in a inperformant manner ( with a for loop trough whole file list ).
          if(searchTerm.equalsIgnoreCase(this.files[x])) { 
          
              console.log("We couldnt find the file in the cache, but we could find it in the whole array, which is very slow. ");
	      console.log("Since we could find the matchedFile we need to add the searchTerm and the matched File to the cache.");
              this.cache.push({ key : searchTerm, value : this.files[x] })
              matchedFile = this.files[x];
          }
          
        }
        
      }
      
      return matchedFile;
  }
  
}

class Storage
{
  
  constructor() 
  {
    if(!this.files) 
        this.files = [ "File 1", "File 2", "File 3", "File 4", "File 5", "File 6",
                       "File 7", "File 8", "File 9", "File 0", "File A", "File B",
	               "File C", "File D", "File E", "File F", "File G", "File H" ];
						    	     
    this.proxy = new Proxy(this.files);
    
  }
  
  search(searchTerm) {
    
    return this.proxy.search(searchTerm);
    
  }
  
}

new Run().main();
