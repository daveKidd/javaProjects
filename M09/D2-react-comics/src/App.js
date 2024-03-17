import './App.css';
import Comic from './Comic';
import farside from './farside.jpg'

function App() {
  return (
    <>
      <header>
        <h1>Most Amazing Comic Strips</h1>
      </header>
      <section>
        <Comic title="Calvin and Hobbes" artist="Bill Watterson"
          release="11/18/1985"
          imgSrc="./pics/calvinhobbes.jpg"
          imgAlt="Calvin and Hobbes Comic" />

        <Comic title="The Far Side" artist="Gary Larson"
          release="12/31/1979"
          imgSrc={farside}
          imgAlt="Far Side Comic" />

        <Comic title="Garfield" artist="Jim Davis"
          release="11/18/1985"
          imgSrc="./pics/garfield.jpg"
          imgAlt="Garfield Comic" />

        <Comic title="Peanuts" artist="Charles M. Schulz"
          release="10/2/1950"
          imgSrc="./pics/peanuts.jpg"
          imgAlt="Peanuts Comic" />
      </section>
      {/* or <Comic></Comic> */}
    </>
  );
}

export default App;