package videogames.ui;

import org.springframework.stereotype.Component;
import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

@Component
public class View {
    Scanner console = new Scanner(System.in);

    public int getMenuOption(){
        displayHeader("What would you like to do?");
        displayText("1. View Video Games\n");
        displayText("2. View Video Game by ID\n");
        displayText("3. Add Video Games\n");
        displayText("4. Update Video Game\n");
        displayText("5. Delete Video Game\n");
        displayText("42. Exit Program\n");

        return readInt("Select [1-5,42 (:]: ");
    }

    public void displayHeader(String header){
        System.out.println();
        System.out.println(header);
        System.out.println("-".repeat(header.length()));
    }

    public void displayText(String line){
        System.out.print(line);
    }

    public void displayErrors(List<String> errors){
        displayHeader("Errors:");
        for(String error : errors){
            displayText(error+"\n");
        }
    }

    public void displayVideoGames(List<VideoGame> videoGames){
        for(VideoGame videoGame : videoGames){
            displayText(String.format("Id: %s%n",videoGame.getId()));
            displayText(String.format("Title: %s%n",videoGame.getTitle()));
            displayText(String.format("Console: %s%n",videoGame.getConsole()));
            displayText(String.format("Price: %s%n",videoGame.getPrice()));
            displayText("--------------------\n");
        }
    }

    public VideoGame makeVideoGame(){
        VideoGame videoGame = new VideoGame();
        videoGame.setTitle(readString("Title: "));
        videoGame.setConsole(getVideoGameConsole("Console type: "));
        videoGame.setPrice(readBigDecimal("Price: "));
        videoGame.setReleaseDate(readLocalDate("Released (MM/dd/yyyy):" ));
        videoGame.setSinglePlayer(readBoolean("Single player? [y/n]:" ));
        return videoGame;
    }

    public VideoGameConsole getVideoGameConsole(String prompt){
        displayHeader("Console types");
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

    public String readString(String prompt){
        displayText(prompt);
        return console.nextLine();
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

    private BigDecimal readBigDecimal(String prompt) {
        while (true) {
            String value = readString(prompt);
            try {
                return new BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN);
            } catch (NumberFormatException ex) {
                System.out.printf("%s is not a valid dollar amount%n",value);
            }
        }
    }

    private LocalDate readLocalDate(String prompt) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        while (true) {
            String value = readString(prompt);
            try {
                return LocalDate.parse(value, dateFormat);
            } catch (DateTimeParseException ex) {
                System.out.printf("%s is not a valid date%n",value);
            }
        }
    }

    private boolean readBoolean(String prompt) {
        String value = readString(prompt);
        return value.startsWith("y") || value.startsWith("Y");
    }
}
