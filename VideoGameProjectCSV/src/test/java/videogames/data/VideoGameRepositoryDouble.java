package videogames.data;

import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;

import java.util.ArrayList;
import java.util.List;

public class VideoGameRepositoryDouble implements VideoGameRepository{

    @Override
    public List<VideoGame> findAll() throws DataAccessException {
        List<VideoGame> all = new ArrayList<>();
        all.add(new VideoGame(1,"The Last of Us", VideoGameConsole.PS5,70));
        all.add(new VideoGame(1,"Overwatch", VideoGameConsole.PC,20));
        all.add(new VideoGame(1,"Resident Evil 4", VideoGameConsole.PC,15));

        return all;
    }

    @Override
    public VideoGame findById(int videoGameId) throws DataAccessException {
        return null;
    }

    @Override
    public VideoGame create(VideoGame videoGame) throws DataAccessException {
        videoGame.setId(42);
        return videoGame;
    }

    @Override
    public boolean update(VideoGame videoGame) throws DataAccessException {
        return videoGame.getId() > 0;
    }

    @Override
    public boolean deleteById(int videoGameId) throws DataAccessException {
        return false;
    }
}
