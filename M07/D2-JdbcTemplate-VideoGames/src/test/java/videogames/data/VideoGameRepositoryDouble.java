package videogames.data;

import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VideoGameRepositoryDouble implements VideoGameRepository {
    @Override
    public List<VideoGame> findAll() throws DataAccessException {
        List<VideoGame> all = new ArrayList<>();
        all.add(new VideoGame(1,"The Last of Us", VideoGameConsole.PS5,new BigDecimal("70.00"), LocalDate.parse("2013-06-14"), true));
        all.add(new VideoGame(2,"Overwatch", VideoGameConsole.PC,new BigDecimal("20"), LocalDate.parse("2016-05-24"), false));
        all.add(new VideoGame(3,"Resident Evil 4", VideoGameConsole.PC,new BigDecimal("15"), LocalDate.parse("2005-01-11"), false));

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
        return videoGameId == 2;
    }
}
