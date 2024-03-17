package videogames.ui;

import org.springframework.stereotype.Component;
import videogames.data.DataAccessException;
import videogames.domain.VideoGameResult;
import videogames.domain.VideoGameService;
import videogames.models.VideoGame;

import java.util.List;

@Component
public class Controller {
    private final View view;
    private final VideoGameService service;

    public Controller(View view, VideoGameService service) {
        this.view = view;
        this.service = service;
    }

    public void run(){
        view.displayHeader("My Video Game Backlog");
        try{
            runMenu();
        }catch(DataAccessException ex){
            view.displayText("Something went wrong: " + ex.getMessage());
        }
        System.out.println("Buh Bye!");
    }

    private void runMenu() throws DataAccessException {
        int selection = view.getMenuOption();
        while(selection != 42){
            switch(selection){
                case 1:
                    viewVideoGames();
                    break;
                case 2:
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
            }
            selection = view.getMenuOption();
        }
    }

    private void viewVideoGames() throws DataAccessException {
        List<VideoGame> videoGames = service.findAll();
        view.displayVideoGames(videoGames);
    }

    private void addVideoGame() throws DataAccessException {
        VideoGame videoGame = view.makeVideoGame();

        VideoGameResult result = service.create(videoGame);
        if (result.isSuccess()){
            view.displayText("The game has been added!");
        }else{
            view.displayErrors(result.getMessages());
        }
    }
}
