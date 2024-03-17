package videogames;

import videogames.data.DataAccessException;
import videogames.data.VideoGameFileRepository;
import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        VideoGameFileRepository repository = new VideoGameFileRepository("./data/video-games.csv");

        try{
            VideoGame foundGame = repository.findById(3);
            System.out.println("the found game is: " + foundGame);
            repository.create(new VideoGame(0,"The Outer Worlds", VideoGameConsole.PC,20));
            repository.update(new VideoGame(12,"Minecraft", VideoGameConsole.XBOX,10));
            repository.deleteById(11);
            List<VideoGame> videoGames = repository.findAll();

            for(VideoGame videoGame : videoGames){
                System.out.println(videoGame);
            }
        }catch(DataAccessException ex){
            System.out.println("Problem retrieving data ):");
        }


        //TODO todo example
    }
}
