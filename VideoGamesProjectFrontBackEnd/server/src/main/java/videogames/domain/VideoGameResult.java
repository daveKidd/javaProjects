package videogames.domain;

import videogames.models.VideoGame;

import java.util.ArrayList;
import java.util.List;

public class VideoGameResult {
    private final List<String> messages = new ArrayList<>();
    private VideoGame videoGame; // payload

    public VideoGame getVideoGame() {
        return videoGame;
    }

    public void setVideoGame(VideoGame videoGame) {
        this.videoGame = videoGame;
    }

    public void addMessage(String message){
        messages.add(message);
    }

    public void addMessage(String message, Object ...args){
        messages.add(String.format(message, args));
    }

    public List<String> getMessages(){
        return messages;
    }

    public boolean isSuccess(){
        return messages.size() == 0;
    }
}

