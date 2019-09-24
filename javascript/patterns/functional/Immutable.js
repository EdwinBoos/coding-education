const compose = (...fns) =>
 fns.reduceRight(
  (prevFn, nextFn) => (...args) => nextFn(prevFn(...args)),
  value => value
 );
const immutable = object => Object.freeze(object);
const tryToMutate = object => {
 object.blue = 244;
 return object;
};
const immutableTest = compose(
 tryToMutate,
 immutable
);
const tuple = immutableTest({
 red: 255,
 green: 0,
 blue: 0
});
console.log(tuple); // Prints { red: 255, green: 0, blue: 0 } in the console
