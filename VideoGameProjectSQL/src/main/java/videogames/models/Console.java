package videogames.models;

import java.util.ArrayList;
import java.util.List;

public class Console {
    private int id;
    private String name;
    private List<VideoGame> videoGames = new ArrayList<>();

    public Console(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VideoGame> getVideoGames() {
        return new ArrayList<>(videoGames);
    }

    public void setVideoGames(List<VideoGame> videoGames) {
        this.videoGames = videoGames;
    }
}
