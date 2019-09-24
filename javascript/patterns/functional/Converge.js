const person = { lastName : "Foo", age : 33, firstName : "Foo_" };
const person2 = { lastName : "Foo2", age : 16, firstName : "Foo_2" };
const lastName = ({lastName}) => lastName; 
const age = ({age}) => age;
const firstName = ({firstName}) => firstName;
const biggerThan18 = number => (number > 18);
const isAdult = R.compose(biggerThan18, age);
const print = R.curry((isAdult, firstName, lastName) => console.log(`${isAdult} ${firstName} ${lastName}`));
const logTwoTimes = R.converge(console.log, [(text) => text, (text) => text]); 
const printPerson = R.converge(print, [isAdult, firstName, lastName]);  

logTwoTimes("hello"); // hello \n hello
printPerson(person); // true, Foo, Foo_
printPerson(person2); // false, Foo2, Foo_2
