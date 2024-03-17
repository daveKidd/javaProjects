package videogames.data;

import videogames.models.VideoGame;

import java.util.List;

public interface VideoGameRepository {
    List<VideoGame> findAll();

    VideoGame findById(int videoGameId);

    VideoGame create(VideoGame videoGame);

    boolean update(VideoGame videoGame);

    boolean deleteById(int videoGameId);
}
