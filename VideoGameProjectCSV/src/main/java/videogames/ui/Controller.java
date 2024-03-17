package videogames.ui;

import videogames.data.DataAccessException;
import videogames.domain.VideoGameResult;
import videogames.domain.VideoGameService;
import videogames.models.VideoGame;

import javax.xml.crypto.Data;
import java.util.List;

public class Controller {
    private final View view;
    private final VideoGameService service;

    public Controller(View view, VideoGameService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        view.displayHeader("Video Game Backlog");
        try{
            runMenu();
        }catch(DataAccessException ex){
            view.displayText("Something went wrong: " + ex.getMessage());
        }
        System.out.println("Buh Bye");
    }

    private void runMenu() throws DataAccessException {
        int selection = view.getMenuOption();
        while(selection != 42){
            switch(selection){
                case 1:
                    viewVideoGames();
                    break;
                case 2:
                    //viewVideoGameById();
                    break;
                case 3:
                    addVideoGame();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 42:
                    break;
                default:
                    System.out.println();
                    System.out.println("Please choose 1-5 or 42");
            }
            selection = view.getMenuOption();
        }
    }

    private void viewVideoGames() throws DataAccessException {
        List<VideoGame> videoGames = service.findAll();
        view.displayVideoGames(videoGames);
    }

    private void addVideoGame() throws DataAccessException {
        VideoGame videoGame = view.askForVideoGame();

        VideoGameResult result = service.create(videoGame);
        if(result.isSuccess()){
            view.displayText(result.getVideoGame().getTitle() + " has been created");
        }else{
            view.displayErrors(result.getMessages());
        }
    }
}
