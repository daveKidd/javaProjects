const assert = require("assert");

// FUNCTION RETURNS A FUNCTION
// Create a function named `makeFunction` that returns a function.
// Use an arrow function for the return value.


// Execute this exercise.
// If you see the message "success!", all tests pass.

// function makeFunction() {
// }

const makeFunction = function() {
  return (newFunction) => newFunction();
  // return () => {};
  // return function() {};
};

const result = makeFunction();
console.log(typeof result);
// result(() => console.log("hello")); // "newFunction" is undefined

assert.strictEqual(typeof result, "function");
console.log("success!");