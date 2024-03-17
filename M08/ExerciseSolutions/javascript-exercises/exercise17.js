const assert = require("assert");
// MERGE AND REMOVE DUPLICATES
// Create a function named `mergeAndRemoveDuplicates`
// that accepts two arrays.
// Create a new array that contains elements from both
// arrays with duplicates removed. Duplicates should be removed if
// they occur in a single parameter array or if there's a duplicated element
// in each parameter.
// Return the result.

const mergeAndRemoveDuplicates = (array1, array2) => {
  const combined = [...array1, ...array2];

  const result = [];

  for (let value of combined) {
    if (!result.includes(value)) {
      result.push(value);
    }
  }

  return result;

  // // [1, 2, 2, 3]
  // return combined.filter((item, index, array) => array.indexOf(item) === index);

  // Set will only include unique values
  // return [...new Set(combined)];
};

// Execute this exercise.
// If you see the message "success!", all tests pass.

assert.deepStrictEqual(mergeAndRemoveDuplicates([1, 2], [2, 3]), [1, 2, 3]);
assert.deepStrictEqual(mergeAndRemoveDuplicates([1, 1, 2], [2, 2, 3]), [1, 2, 3]);
assert.deepStrictEqual(mergeAndRemoveDuplicates(["one", 2, true], [true, false, "two"]), ["one", 2, true, false, "two"]);
assert.deepStrictEqual(mergeAndRemoveDuplicates([], []), []);
assert.deepStrictEqual(mergeAndRemoveDuplicates(["red"], ["blue"]), ["red", "blue"]);
assert.deepStrictEqual(mergeAndRemoveDuplicates(["red", "green", "blue"], ["blue", "yellow"]), ["red", "green", "blue", "yellow"]);

console.log("success!");