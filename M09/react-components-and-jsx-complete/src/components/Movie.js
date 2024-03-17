
function Movie({ movie, deleteMovie  }) {
  return (
    <div>
      <h3>{movie.title}</h3>
      <h4>{movie.releaseYear}</h4>
      <button onClick={() => deleteMovie(movie.id)}>Delete</button>
    </div>
  );
}

export default Movie;
