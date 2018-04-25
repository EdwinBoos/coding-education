# webassembly-test
A webassembly performance test vs default js.

    1. A c file was created with a add method which simply returns a+b (run.c)
    
    2. The c file was compiled to a .wasm file (run.wasm). 
       ( you can compile it locally with tools like eccm, or here online :  https://wasdk.github.io/WasmFiddle/ ).
     
    3. The index.html file got a add function aswell but implemented in default javascript. 
    
    4. After the run.wasm file was loaded in the index.html file, call add in c and test performance, and do the same for 
       default JavaScript.
       
    The Console Output here is: 


       # duration of wasm call :  0.009999999999934062
       # ==================================
       # duration of default js call : 0.0999999999999659

    As expected the wasm add-call was faster.


