package videogames.data;

import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VideoGameFileRepository {
    private final static String DELIMITER = ",";

    private final String filePath;

    public VideoGameFileRepository(String filePath) {
        this.filePath = filePath;
    }

    public List<VideoGame> findAll() throws DataAccessException{
        List<VideoGame> result = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            reader.readLine();// skips header row
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] fields = line.split(DELIMITER);
                if(fields.length != 4){
                    continue;
                }

                VideoGame videoGame = new VideoGame(
                    Integer.parseInt(fields[0]),
                    fields[1],
                    VideoGameConsole.valueOf(fields[2]),
                    Double.parseDouble(fields[3])
                );

                result.add(videoGame);
            }
            return result;
        }catch(FileNotFoundException ex){

        }catch(IOException ex){
            throw new DataAccessException("Could not open file path " + filePath,ex);
        }

        return result;
    }

    public VideoGame findById(int videoGameId) throws DataAccessException {
        List<VideoGame> all = findAll();
        for (VideoGame videoGame : all) {
            if (videoGame.getId() == videoGameId) {
                return videoGame;
            }
        }
        return null;
    }

    public VideoGame create(VideoGame videoGame) throws DataAccessException{
        List<VideoGame> all = findAll();
        int nextId = getNextId(all);
        videoGame.setId(nextId);
        all.add(videoGame);
        writeToFile(all);
        return videoGame;
    }

    public boolean update(VideoGame videoGame) throws DataAccessException {
        List<VideoGame> all = findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getId() == videoGame.getId()) {
                all.set(i, videoGame);
                writeToFile(all);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(int videoGameId) throws DataAccessException {
        List<VideoGame> all = findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getId() == videoGameId) {
                all.remove(i);
                writeToFile(all);
                return true;
            }
        }
        return false;
    }


    private void writeToFile(List<VideoGame> videoGames) throws DataAccessException{
        try(PrintWriter writer = new PrintWriter(filePath)){
            writer.println("id,title,console,price");

            for(VideoGame videoGame:videoGames){

                String eachGame = videoGame.getId() + DELIMITER +
                        videoGame.getTitle() + DELIMITER +
                        videoGame.getConsole() + DELIMITER +
                        videoGame.getPrice();

                writer.println(eachGame);
            }
        }catch(IOException ex){
            throw new DataAccessException("Could not write to file path: " + filePath,ex);
        }
    }

    private int getNextId(List<VideoGame> videoGames){
        int maxId = 0;
        for(VideoGame videoGame:videoGames){
            if(maxId < videoGame.getId()){
                maxId = videoGame.getId();
            }
        }
        return maxId+1;
    }
}
