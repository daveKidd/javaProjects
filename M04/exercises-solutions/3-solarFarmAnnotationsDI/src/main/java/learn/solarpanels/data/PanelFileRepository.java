package learn.solarpanels.data;

import learn.solarpanels.models.MaterialType;
import learn.solarpanels.models.Panel; // this is so I can access the constructor and getters/setters
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*; //import the whole java.io package
import java.util.ArrayList; // so I can use arrayLists
import java.util.List; //so I can use Lists

@Repository
public class PanelFileRepository {
    private final String filePath;
    private final String delimiter = "~"; // sets up what separates each part of the txt file

    public PanelFileRepository(@Value("${solarPanelFilePath}") String filePath){ // constructor that builds filePath field
        this.filePath = filePath;
    }
    // creates a new list from the Panel model, if there's an error it will throw it to DataAccessException
    public List<Panel> findAll() throws DataAccessException{ //this will find all panels in certain section
        ArrayList<Panel> result = new ArrayList<>(); // this will hold all the panels in the section

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            for(String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] fields = line.split(delimiter);
                if (fields.length == 6) {
                    Panel panel = new Panel();
                    panel.setSection(fields[0]);
                    panel.setRow(Integer.parseInt(fields[1]));
                    panel.setColumn(Integer.parseInt(fields[2]));
                    panel.setYear(Integer.parseInt(fields[3]));
                    panel.setMaterial(MaterialType.valueOf(fields[4]));
                    panel.setTracking("true".equals(fields[5]));
                    result.add(panel);
                }
            }
        }catch (FileNotFoundException ex){
            // this runs if there are no Panels yet
        }catch (IOException ex){
            throw new DataAccessException("Can't open file path " + filePath, ex);
        }
        return result;
    }

    public List<Panel> findBySection(String section) throws DataAccessException{
        List<Panel> all = findAll();
        ArrayList<Panel> allSections = new ArrayList<>();
        for(Panel panel : all){
            if(panel.getSection().equals(section)){
                allSections.add(panel);
            }
        }
        return allSections;
    }

    public Panel findBySectionRowCol(String section,int row, int col) throws DataAccessException{
        List<Panel> all = findAll();
        for(Panel panel : all){
            if(panel.getSection().equals(section) && panel.getRow() == row && panel.getColumn() == col){
                return panel;
            }
        }
        return null;
    }

    public Panel add(Panel panel) throws DataAccessException{
        List<Panel> all = findAll();
        all.add(panel);
        writeAll(all);  // writeAll is in this class
        return panel;
    }

    public boolean update(Panel panel) throws DataAccessException{
        List<Panel> all = findAll();

        for(int i=0; i<all.size(); i++){ // we need i for the index location of the panel in the List all
            if(all.get(i).getSection().equals(panel.getSection()) && all.get(i).getRow() == panel.getRow()
                    && all.get(i).getColumn() == panel.getColumn()){
                all.set(i,panel); // this goes to the index of i and changes it to panel's info
                writeAll(all); // this uses write all to update the .txt will all of the panels including the new one
                return true;
            }
        }
        return false;
    }

    public boolean deleteBySectionRowCol(String section, int row, int col) throws DataAccessException {
        List<Panel> all = findAll();
        for(int i=0; i<all.size(); i++){ // we need i for the index location of the panel in the List all
            if(all.get(i).getSection().equals(section) && all.get(i).getRow() == row
                    && all.get(i).getColumn() == col){
                all.remove(i); // this goes to the index of i and removes it from all
                writeAll(all); // this uses write all to update the .txt will all of the panels  not including the deleted one
                return true;
            }
        }
        return false;
    }

    private void writeAll(List<Panel> panels) throws DataAccessException{
        try(PrintWriter writer = new PrintWriter(filePath)){
            for(Panel panel : panels){
                writer.println(serialize(panel)); // serialize is in this class
            }
        }catch (IOException ex){
            throw new DataAccessException("Could not write to path: " + filePath, ex);
        }
    }

    private String serialize(Panel panel){
        return String.format("%s~%s~%s~%s~%s~%s",
            panel.getSection(),
            panel.getRow(),
            panel.getColumn(),
            panel.getYear(),
            panel.getMaterial(),
            panel.isTracking());
    }
}
