let leo = {
    weapon: "katana",
    color: "blue",
    favFood: "pizza"
};

console.log(leo.weapon, leo["color"]);

for (let key in leo) {    
    console.log(key + " = " + leo[key]);
}

Object.keys(leo).forEach(function(key) {
    console.log(key, leo[key]);  
});

Object.keys(leo).forEach(key => {
    console.log(key, leo[key]);  
});

leoStringified = JSON.stringify(leo);
console.log(leoStringified)

leoParsed = JSON.parse(leoStringified);
console.log(leoParsed)


// Arrays
// let ninjaTurtles = ["Leo","Ralph","Don","Mikey"];
// console.log(ninjaTurtles[1])
// console.log(ninjaTurtles[4])
// ninjaTurtles.push("Splinter")
// console.log(ninjaTurtles[4])
// console.log(ninjaTurtles[200])

// for(t in ninjaTurtles){
//     console.log(t)
//     console.log(ninjaTurtles[t]);
// }

// ninjaTurtles.forEach(t => {
//     console.log(t) //ninjaTurles[0]
// });

// let startsWithS = ninjaTurtles.filter(t => {
//     return t.startsWith("S")
// });
// console.log(startsWithS);

// let [first,second, ...others] = ninjaTurtles;
// console.log(ninjaTurtles)
// console.log(first)
// console.log(typeof first)
// console.log(second)
// console.log(others)


// closure
// function outerFunction(outerVariable){
//     return function innerFunction(innerVariable){
//         console.log("Outer Variable: " + outerVariable)
//         console.log("Inner Variable: " + innerVariable)
//     }
// }

// const newFunction = outerFunction("outside");
// newFunction("inner");

// rest parameters
// function f2(a, b, ...c) {
//     console.log(a, b, c);
// }

// f2();              
// f2(1, 2);          
// f2(1, 2, 3);          
// f2(1, 2, 3, 4, 5, 6, 7, 8);


// default parameters
// function defaultParameters(a = 19, b = "chime", c="dude") {
//     console.log(a, b, c);
// }

// defaultParameters();                  
// defaultParameters(27);                
// defaultParameters(27, "surf");        
// defaultParameters(27, "surf", false); 


// function repeatMySelf(message, times) {
//     for(let i = 0; i < times; i++) {
//         console.log(message);
//     }
// }

// repeatMySelf("Hi",4);

// let firstName = "Dave";
// let sentence = "is the greatest";
// console.log(firstName + " " + sentence);
// console.log(`${firstName} ${sentence}`);  //tick marks ``



// Length
// let whyHello = "Why hello";
// console.log(whyHello.length)


// Truthiness
// if (true) { // use a boolean or an operation that results in a boolean, it works great
//     console.log("true literal is true");
// }

// if ("some string") { // string literals...evaluate to true
//     console.log("string literal is true");
// }

// if (null) { // this does not evaluate to true
//     console.log("null literal is true");
// }

// if (undefined) { // this does not evaluate to true
//     console.log("undefined literal is true");
// }

// if ({}) { // object literal evaluates to true
//     console.log("object literal is true");
// }

// if ([]) { // array literal evaluates to true
//     console.log("array literal is true");
// }


// equality
// let fiveString = "5"
// let fiveInt = 5
// console.log(fiveString + fiveInt)

// if(fiveInt === fiveString){
//     console.log(true)
// }else{
//     console.log(false)
// }

// typeof
// let value;
// let value2 = "";
// let value3 = 0;
// console.log(typeof value); //<--Don't forget semi-colons
// value = 25;
// console.log(typeof value); // number
// value = "Hodgepodge";
// console.log(typeof value); // string
// value = true;
// console.log(typeof value); // boolean
// value = {};
// console.log(typeof value); // object
// value = [];
// console.log(typeof value); // object
// value = null;
// console.log(typeof value); // object



/*
multi line
console.log("hello")
*/
// single line