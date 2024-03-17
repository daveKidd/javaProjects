package videogames.ui;

import org.springframework.stereotype.Component;
import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;

import java.util.List;
import java.util.Scanner;

@Component
public class View {
    Scanner console = new Scanner(System.in);

    public VideoGame askForVideoGame(){
        VideoGame videoGame = new VideoGame();
        videoGame.setTitle(readString("Title: "));
        videoGame.setConsole(getVideoGameConsole("Console: "));
        videoGame.setPrice(readDouble("Price: "));
        return videoGame;
    }

    public void displayErrors(List<String> errors){
        displayHeader("Errors:");
        for(String error: errors){
            displayText(error + "\n");
        }
    }

    public VideoGameConsole getVideoGameConsole(String prompt){
        displayHeader("Console types: ");
        for(VideoGameConsole console : VideoGameConsole.values()){
            displayText(console.toString()+"\n");
        }
        while(true){
            String choice = readString(prompt);
            try{
                return VideoGameConsole.valueOf(choice);
            }catch(IllegalArgumentException ex){
                System.out.printf("%s is not a valid console%n",choice);
            }
        }
    }

    public int getMenuOption(){
        while(true){
            displayHeader("What would you like to do?");
            displayText("1. View All Video Games\n");
            displayText("2. View Video Game By Id\n");
            displayText("3. Add Video Game\n");
            displayText("4. Update Video Game\n");
            displayText("5. Delete Video Game\n");
            displayText("42. Exit Program\n");
            int selection = readInt("Select [1-5, 42]: ");
            if(selection >= 1 && selection <= 5 || selection == 42){
                return selection;
            }else{
                displayText("\nPlease choose 1-5 or 42 (:\n");
            }
        }
    }


    public void displayVideoGames(List<VideoGame> videoGames){
        for(VideoGame videoGame : videoGames){
            displayText(String.format("Id: %s%n",videoGame.getId()));
            displayText(String.format("Title: %s%n",videoGame.getTitle()));
            displayText(String.format("Console: %s%n",videoGame.getConsole()));
            displayText(String.format("Price: %.2f%n",videoGame.getPrice()));
            displayText("-----------------\n");
        }
    }

    public void displayHeader(String header){
        System.out.println();
        System.out.println(header);
        System.out.println("-".repeat(header.length()));
    }

    public void displayText(String line){
        System.out.print(line);
    }

    public String readString(String prompt){
        displayText(prompt);
        return console.nextLine();
    }

    public Double readDouble(String prompt){
        while(true){
            String value = readString(prompt);
            try{
                return Double.parseDouble(value);
            }catch(NumberFormatException ex){
                System.out.printf("%s is not a valid number%n",value);
            }
        }
    }

    public int readInt(String prompt){
        while(true){
            String value = readString(prompt);
            try{
                return Integer.parseInt(value);
            }catch(NumberFormatException ex){
                System.out.printf("%s is not a valid number%n",value);
            }
        }
    }
}
