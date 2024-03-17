// SWITCH MOD DAY
// Given a positive day, assuming that day 1 is Monday, day 2 is Tuesday,
// ... day 9 is Tuesday (days "wrap"), day 21 is Sunday, etc.
// Use a switch statement to print the appropriate day of the week.
// You should be able to handle all positive integers.

/* Examples
1 -> "Monday" 
2 -> "Tuesday"
3 -> "Wednesday"
4 -> "Thursday"
5 -> "Friday"
6 -> "Saturday"
7 -> "Sunday" 0
8 -> "Monday"
9 -> "Tuesday"
10 -> "Wednesday"
11 -> "Thursday"
12 -> "Friday"
13 -> "Saturday"
14 -> "Sunday"
15 -> "Monday"
16 -> "Tuesday"
etc...
*/

const day = 22;

// Write code here.

let dayOfWeek = '';

const normalizedDay = day % 7;

switch (normalizedDay) {
  case 1:
    dayOfWeek = 'Monday';
    break;
  case 2:
    dayOfWeek = 'Tuesday';
    break;
  case 3:
    dayOfWeek = 'Wednesday';
    break;
  case 4:
    dayOfWeek = 'Thursday';
    break;
  case 5:
    dayOfWeek = 'Friday';
    break;
  case 6:
    dayOfWeek = 'Saturday';
    break;
  case 0:
    dayOfWeek = 'Sunday';
    break;
}

console.log(dayOfWeek);
