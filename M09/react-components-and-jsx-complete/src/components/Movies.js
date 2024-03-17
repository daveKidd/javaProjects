import { useState } from 'react';
import Movie from './Movie';

const MOVIES_DATA = [
  { id: 1, title: 'Toy Story', releaseYear: 1995 },
  { id: 2, title: 'The Iron Giant', releaseYear: 1999 },
  { id: 3, title: 'Spider-Man: Into the Spider-Verse', releaseYear: 2018 },
];

function Movies() {
  const [movies, setMovies] = useState(MOVIES_DATA);

  const handleAddMovieClick = () => {
    // HACK we don't need to this once we start using an API
    const movieIds = movies.map(m => m.id);
    const nextId = movieIds.length > 0 ? Math.max(...movieIds) + 1 : 1;
    console.log(nextId);

    const newMovie = {
      id: nextId,
      title: 'Some New Movie',
      releaseYear: 2000
    };

    // create a copy
    const newMovies = [...movies];

    // add the movie
    newMovies.push(newMovie);

    // update the state
    setMovies(newMovies);
  };

  const deleteMovie = (movieId) => {
    // remove the movie to delete
    const newMovies = movies.filter(movie => movie.id !== movieId);

    // update the state
    setMovies(newMovies);
  };

  return (
    <div>
      <button onClick={handleAddMovieClick}>Add Movie</button>
      {movies.map(m => (
        <Movie key={m.id} movie={m} deleteMovie={deleteMovie} />
      ))}
    </div>
  );
}

export default Movies;
