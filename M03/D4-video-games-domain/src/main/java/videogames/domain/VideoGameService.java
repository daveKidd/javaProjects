package videogames.domain;

import videogames.data.DataAccessException;
import videogames.data.VideoGameRepository;
import videogames.models.VideoGame;

import java.util.List;

public class VideoGameService {
    private final VideoGameRepository repository;

    public VideoGameService(VideoGameRepository repository) {
        this.repository = repository;
    }

    public List<VideoGame> findAll() throws DataAccessException {
        return repository.findAll();
    }

    public VideoGameResult create(VideoGame videoGame) throws DataAccessException{
        VideoGameResult result = validate(videoGame);

        if(!result.isSuccess()){
            return result;
        }

        if(videoGame.getId() > 0){
            result.addMessage("Can't create an existing video game");
            return result;
        }

        videoGame = repository.create(videoGame);
        result.setVideoGame(videoGame);
        return result;
    }

    public VideoGameResult update(VideoGame videoGame) throws DataAccessException {
        VideoGameResult result = validate(videoGame);

        if(!result.isSuccess()){
            return result;
        }

        boolean updated = repository.update(videoGame);

        if(!updated){
            result.addMessage("Video game not found");
        }

        return result;
    }

    public VideoGameResult validate(VideoGame videoGame){
        VideoGameResult result = new VideoGameResult();

        if(videoGame == null){
            result.addMessage("Video game can't be null");
            return result;
        }

        if(videoGame.getTitle() == null || videoGame.getTitle().isEmpty()){
            result.addMessage("Title is required");
            return result;
        }

        if(videoGame.getConsole() == null){
            result.addMessage("Console is required");
            return result;
        }

        if(videoGame.getPrice() < 1 || videoGame.getPrice() > 70){
            result.addMessage("Price must be between 1 and 70");
            return result;
        }

        return result;
    }
}
