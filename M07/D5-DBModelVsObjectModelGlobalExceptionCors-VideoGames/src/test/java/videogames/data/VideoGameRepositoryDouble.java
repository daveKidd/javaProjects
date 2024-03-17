package videogames.data;

import videogames.models.VideoGame;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VideoGameRepositoryDouble implements VideoGameRepository {
    @Override
    public List<VideoGame> findAll() {
        List<VideoGame> all = new ArrayList<>();
        all.add(new VideoGame(1, "The Last of Us", new BigDecimal("70.00"),
                LocalDate.parse("2013-06-14"), true,1));
        all.add(new VideoGame(2, "Overwatch", new BigDecimal("20"),
                LocalDate.parse("2016-05-24"), false,1));
        all.add(new VideoGame(3, "Resident Evil 4", new BigDecimal("15"),
                LocalDate.parse("2005-01-11"), false,1));

        return all;
    }

    @Override
    public VideoGame findById(int videoGameId) {
        return null;
    }

    @Override
    public VideoGame create(VideoGame videoGame) {
        videoGame.setId(42);
        return videoGame;
    }

    @Override
    public boolean update(VideoGame videoGame) {
        return videoGame.getId() > 0;
    }

    @Override
    public boolean deleteById(int videoGameId) {
        return videoGameId == 2;
    }
}
