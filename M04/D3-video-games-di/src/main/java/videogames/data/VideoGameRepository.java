package videogames.data;

import videogames.models.VideoGame;

import java.util.List;

public interface VideoGameRepository {
    List<VideoGame> findAll() throws DataAccessException;

    VideoGame findById(int videoGameId) throws DataAccessException;

    VideoGame create(VideoGame videoGame) throws DataAccessException;

    boolean update(VideoGame videoGame) throws DataAccessException;

    boolean deleteById(int videoGameId) throws DataAccessException;
}
