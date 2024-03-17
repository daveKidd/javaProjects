package videogames.domain;

import org.springframework.stereotype.Service;
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

    public List<VideoGame> findAll() {
        return repository.findAll();
    }

    public VideoGame findById(int id) {
        return repository.findById(id);
    }

    public Result<VideoGame> create(VideoGame videoGame) {
        Result<VideoGame> result = validate(videoGame);

        if (!result.isSuccess()) {
            return result;
        }

        if (videoGame.getId() > 0) {
            result.addMessage(ResultType.INVALID, "Cannot create an existing Video Game");
            return result;
        }

        videoGame = repository.create(videoGame);
        result.setPayload(videoGame);
        return result;
    }

    public Result<VideoGame> update(VideoGame videoGame) {
        Result<VideoGame> result = validate(videoGame);

        if (!result.isSuccess()) {
            return result;
        }

        boolean updated = repository.update(videoGame);

        if (!updated) {
            result.addMessage(ResultType.NOT_FOUND, "Video game doesn't exist");
        }

        return result;
    }

    public Result<Void> deleteById(int videoGameId) {
        Result<Void> result = new Result<>();
        if (!repository.deleteById(videoGameId)) {
            result.addMessage(ResultType.NOT_FOUND, "Video game: %s doesn't exist", videoGameId);
        }
        return result;
    }

    private Result<VideoGame> validate(VideoGame videoGame) {
        Result<VideoGame> result = new Result<>();

        if (videoGame == null) {
            result.addMessage(ResultType.INVALID,"Video Game can't be null");
            return result;
        }

        if (videoGame.getTitle() == null || videoGame.getTitle().isBlank()) {
            result.addMessage(ResultType.INVALID,"Title is required");
        }

        if (videoGame.getPrice() == null
                || videoGame.getPrice().compareTo(BigDecimal.ONE) < 0
                || videoGame.getPrice().compareTo(new BigDecimal("70")) > 0) {
            result.addMessage(ResultType.INVALID,"Price must be between 1 and 70");
        }

        if (videoGame.getReleaseDate() == null) {
            result.addMessage(ResultType.INVALID,"Release date is required");
        }

//        if (isDuplicate(videoGame)) {
//            result.addMessage(ResultType.INVALID,"'%s' for %s has already been added",
//                    videoGame.getTitle(), videoGame.getConsole());
//        }

        return result;
    }

//    private boolean isDuplicate(VideoGame videoGame) {
//        return findAll().stream()
//                .anyMatch(game -> game.getId() != videoGame.getId()
//                        && game.getTitle().equals(videoGame.getTitle())
//                        && game.getConsole() == videoGame.getConsole());
//    }

}
