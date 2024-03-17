const assert = require("assert");

// FIRST VOWEL
// Complete the function `getFirstVowel`.
// It should return the first vowel in a string.
// If the string doesn't contain vowels, `value` is null, 
// or `value` is undefined, return an empty string.

function getFirstVowel(value) {
  // if no argument is passed... value will be "undefined"
  console.log(value);

  // if (!(value === undefined || value === null)) {
  // }

  if (value) { // truthy and falsy
    const vowels = 'aeiou';

    for (let index = 0; index < value.length; index++) {
      const character = value.charAt(index);
      if (vowels.includes(character.toLowerCase())) {
        return character;
      }
    }  
  }

  return '';
}

// Node's assert library will test your function.
// Execute this exercise.
// If you see the message "success!", all tests pass.

assert.strictEqual(getFirstVowel("magnificent"), "a");
assert.strictEqual(getFirstVowel("winsome"), "i");
assert.strictEqual(getFirstVowel("xxx"), "");
assert.strictEqual(getFirstVowel(), "");
assert.strictEqual(getFirstVowel("mAgnificent"), "A");

console.log("success!");