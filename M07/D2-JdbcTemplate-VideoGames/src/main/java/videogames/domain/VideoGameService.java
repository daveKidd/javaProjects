package videogames.domain;

import org.springframework.stereotype.Service;
import videogames.data.DataAccessException;
import videogames.data.VideoGameRepository;
import videogames.models.VideoGame;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VideoGameService {
    private final VideoGameRepository repository;

    public VideoGameService(VideoGameRepository repository) {
        this.repository = repository;
    }

    public List<VideoGame> findAll() throws DataAccessException {
        return repository.findAll();
    }

    public VideoGameResult create(VideoGame videoGame) throws DataAccessException {
        VideoGameResult result = validate(videoGame);

        if (!result.isSuccess()) {
            return result;
        }

        if (videoGame.getId() > 0) {
            result.addMessage("Cannot create an existing Video Game");
            return result;
        }

        videoGame = repository.create(videoGame);
        result.setVideoGame(videoGame);
        return result;
    }

    public VideoGameResult update(VideoGame videoGame) throws DataAccessException {
        VideoGameResult result = validate(videoGame);

        if (!result.isSuccess()) {
            return result;
        }

        boolean updated = repository.update(videoGame);

        if (!updated) {
            result.addMessage("Video game doesn't exist");
        }

        return result;
    }

    public VideoGameResult deleteById(int videoGameId) throws DataAccessException {
        VideoGameResult result = new VideoGameResult();
        if (!repository.deleteById(videoGameId)) {
            result.addMessage("Video game: %s doesn't exist", videoGameId);
        }
        return result;
    }

    private VideoGameResult validate(VideoGame videoGame) throws DataAccessException {
        VideoGameResult result = new VideoGameResult();

        if (videoGame == null) {
            result.addMessage("Video Game can't be null");
            return result;
        }

        if (videoGame.getTitle() == null || videoGame.getTitle().isBlank()) {
            result.addMessage("Title is required");
        }

        if (videoGame.getPrice() == null
                || videoGame.getPrice().compareTo(BigDecimal.ONE) < 0
                || videoGame.getPrice().compareTo(new BigDecimal("70")) > 0) {
            result.addMessage("Price must be between 1 and 70");
        }

        if (videoGame.getConsole() == null) {
            result.addMessage("Console is required");
        }

        if (videoGame.getReleaseDate() == null) {
            result.addMessage("Release date is required");
        }

        if (isDuplicate(videoGame)) {
            result.addMessage("'%s' for %s has already been added",
                    videoGame.getTitle(), videoGame.getConsole());
        }

        return result;
    }

    private boolean isDuplicate(VideoGame videoGame) throws DataAccessException {
        return findAll().stream()
                .anyMatch(game -> game.getId() != videoGame.getId()
                        && game.getTitle().equals(videoGame.getTitle())
                        && game.getConsole() == videoGame.getConsole());
    }

}
