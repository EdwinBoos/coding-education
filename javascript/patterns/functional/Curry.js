const data = [
 { name: "al", age: 18 },
 { name: "al", age: 32 },
 { name: "foo", age: 30 }
];
const main = () => {
 const curriedLog = curry(log);
 const warningLevelLog = curriedLog("Warning");
 const infoLevelLog = curriedLog("Info");
 warningLevelLog("first warning");
 warningLevelLog("second warning");
 data
  .filter(greater("age", 18))
  .filter(by("name", "foo"))
  .map(object => infoLevelLog(object.name)); // Logs foo
};

function greater(key, value) {
 return object => object[key] > value;
}

function by(key, value) {
 return object => object[key] === value;
}

function curry(originalFunction, initialParams = []) {
 return (...nextParams) => {
  const curriedFunction = params => {
   if (params.length === originalFunction.length) {
    return originalFunction(...params);
   }
   return curry(originalFunction, params);
  };
  return curriedFunction([...initialParams, ...nextParams]);
 };
}

function log(level, text) {
 console.log(`${level} : ${text}`);
}

main();
