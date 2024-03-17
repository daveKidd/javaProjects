import learn.VideoGame;

import java.util.ArrayList;

public class Exercise14 {
    public static void main(String[] args) {
        ArrayList<VideoGame> videoGames = new ArrayList<>();

        videoGames.add(new VideoGame("Last Of Us",2013,1,"Adventure"));
        videoGames.add(new VideoGame("God of War",2013,1,"Adventure"));
        videoGames.add(new VideoGame("Horizon Zero Dawn",2013,1,"Adventure"));

        for(VideoGame game: videoGames){
            System.out.println(game);
        }
    }
}
