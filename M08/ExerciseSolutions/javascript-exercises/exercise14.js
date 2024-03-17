const assert = require("assert");
// PUSH THE REST
// 1. Create a function.
// Name: pushTheRest
// Parameters: any, any, ...rest parameter
// Returns: an array
// Description: Return the rest paramter.
// If no arguments are passed, do nothing but return the rest parameter.
// If one argument is passed, push it in the rest parameter before return.
// If two or more arguments are passed, push the first two args in the rest parameter
// and return.

const pushTheRest = (any1, any2, ...rest) => {
  // do I have a parameter value...
  if (any1 !== undefined) {
    rest.push(any1);
  }

  // do I have a parameter value...
  if (any2 !== undefined) {
    rest.push(any2);
  }

  return rest;
};

// Execute this exercise.
// If you see the message "success!", all tests pass.

assert.deepStrictEqual(pushTheRest(1, 2, 3, 4), [3, 4, 1, 2]);
assert.deepStrictEqual(pushTheRest("a", "b", "c", "d", "e"), ["c", "d", "e", "a", "b"]);
assert.deepStrictEqual(pushTheRest(true, false), [true, false]);
assert.deepStrictEqual(pushTheRest(23), [23]);
assert.deepStrictEqual(pushTheRest(), []);
assert.deepStrictEqual(pushTheRest({}, {}, {}), [{}, {}, {}]);

console.log("success!");