// ITEM BETWEEN ARRAYS
// Create a function that accepts an array, any other value, and an array.
// Return a new array that includes all elements from the first array, the value, then
// all the elements from the last array parameter.
// Hint: spread syntax is useful here.

/* Examples
[1, 2], "a", [true]                   => [1, 2, "a", true]
[], 87, [9]                           => [87, 9]
[14, 15], 0, []                       => [14, 15, 0]
["red", "blue"], "orange", ["yellow"] => ["red", "blue", "orange", "yellow"]
["red"], ["orange"], ["yellow"]       => ["red", ["orange"], "yellow"]
*/

// Confirm your result by debugging or printing to the console.

// const values = [{}, {}];
// const copyValues = [...values];

const mergeArraysAndValue = (array1, value, array2) => {
  return [ ...array1, value, ...array2 ];
};

console.log(mergeArraysAndValue([1, 2], "a", [true]));
console.log(mergeArraysAndValue([], 87, [9]));
console.log(mergeArraysAndValue([14, 15], 0, []));
console.log(mergeArraysAndValue(["red", "blue"], "orange", ["yellow"]));
console.log(mergeArraysAndValue(["red"], ["orange"], ["yellow"]));
