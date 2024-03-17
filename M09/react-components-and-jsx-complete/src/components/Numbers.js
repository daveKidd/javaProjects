
function Numbers({min, max}) {
  const numbersToDisplay = [];
  for (let i = min; i <= max; i++) {
    numbersToDisplay.push(i);
  }

  console.log(numbersToDisplay);

  return (
    <ul>
      {numbersToDisplay.map(n => (
        <li>{n}</li>
      ))}
    </ul>
  );
}

export default Numbers;
