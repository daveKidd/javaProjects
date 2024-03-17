// PRINT BUSINESS CARD
// Create a function named `printBusinessCard` that accepts an object.
// The object may contain the following properties:
// jobTitle, firstName, and lastName, pithyPhrase
/* Print a business card in the following format:

  Rue Majors
  Architect
  "It's better to burn out than it is to fade away."

Generically:

  firstName lastName
  jobTitle
  "pithyPhrase"
*/
// If any property is missing, omit it. If a missing property creates an empty line, omit the line.
// Hint: object destructing is useful, but not required, here.




// TODO write the function without object destructuring

// const printBusinessCard = (person) => {
//   let name = '';

//   if (person.firstName && person.lastName) {
//     name = `${person.firstName} ${person.lastName}`;
//   } else if (person.firstName) {
//     name = person.firstName;
//   } else if (person.lastName) {
//     name = person.lastName;
//   }

//   if (name) {
//     console.log(name);
//   }

//   if (person.jobTitle) {
//     console.log(person.jobTitle);
//   }

//   if (person.pithyPhrase) {
//     console.log(person.pithyPhrase);
//   }

//   console.log('');
// };

// TODO write the function with object destructuring

const printBusinessCard = ({ firstName, lastName, jobTitle, pithyPhrase }) => {
  let name = '';

  if (firstName && lastName) {
    name = `${firstName} ${lastName}`;
  } else if (firstName) {
    name = firstName;
  } else if (lastName) {
    name = lastName;
  }

  if (name) {
    console.log(name);
  }

  if (jobTitle) {
    console.log(jobTitle);
  }

  if (pithyPhrase) {
    console.log(pithyPhrase);
  }

  console.log('');
};

printBusinessCard({
    jobTitle: "Architect",
    firstName: "Rue",
    lastName: "Majors",
    pithyPhrase: "It's better to burn out than it is to fade away."
});
/* Expected output:

  Rue Majors
  Architect
  "It's better to burn out than it is to fade away."
*/

printBusinessCard({
    firstName: "Mac",
    lastName: "Gorrie"
});
/* Expected output:

  Mac Gorrie
*/

printBusinessCard({
    jobTitle: "Instructor",
    firstName: "Netta",
    pithyPhrase: "Happy to help!"
});
/* Expected output:

  Netta
  Instructor
  "Happy to help!"
*/

printBusinessCard({
    jobTitle: "Mystery Guest",
    pithyPhrase: "Life is an illusion..."
});

/* Expected output:

  Mystery Guest
  "Life is an illusion..."
*/