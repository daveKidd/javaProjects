
const print = (values) => {
  // find the length of the longest string
  // let longestStringLength = 0;
  // for (let value of values) {
  //   if (value.length > longestStringLength) {
  //     longestStringLength = value.length;
  //   }
  // }
  // console.log(longestStringLength);

  // find the length of the longest string
  const longestStringLength = Math.max(...values.map(s => s.length));

  // print each string and left pad using the length of the longest string
  values.forEach(s => console.log(s.padStart(longestStringLength, ' ')));
};

print(["one", "two hundred", "fifty"]);
print(["yes", "no"]);
print(["merciful", "cold", "beyond reproach", "brighter", "sad"]);
