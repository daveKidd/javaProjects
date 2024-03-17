// INTERLEAVE
const first = "wha?";
const second = "";

// 1. Write a loop to interleave two strings to form a new string.
// To interleave, during each loop take one character from the first string and add it to the result
// and take one character from the second string and add it to the result.
// If there are no more characters available, don't add characters.
// 2. Print the result.

// Examples
// "abc", "123" -> "a1b2c3"
// "cat", "dog" -> "cdaotg"
// "wonder", "o" -> "woonder"
// "B", "igstar" -> "Bigstar"
// "", "huh?" -> "huh?"
// "wha?", "" -> "wha?"

let result = '';

const lengthOfLongestString = first.length > second.length ? first.length : second.length;

for (let index = 0; index < lengthOfLongestString; index++) {
  if (index < first.length) {
    result = result + first.charAt(index);
  }
  if (index < second.length) {
    result = result + second.charAt(index);
  }
}

console.log(result);
