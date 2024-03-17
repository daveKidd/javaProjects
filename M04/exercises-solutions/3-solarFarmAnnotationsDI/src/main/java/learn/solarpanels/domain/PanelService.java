package learn.solarpanels.domain;

import learn.solarpanels.data.DataAccessException;
import learn.solarpanels.data.PanelFileRepository;
import learn.solarpanels.models.MaterialType;
import learn.solarpanels.models.Panel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PanelService {
    // makes a var called repository that will hold an instance from PanelFileRepository
    // we bring in repository as a bridge so the UI doesn't talk with the data layer.
    private final PanelFileRepository repository;
    private String addOrUpdate;

    public PanelService(PanelFileRepository repository) {
        // this takes the repository and constructs a repository field out of it for PanelService
        this.repository = repository;
    }

    public List<Panel> findBySection(String section) throws DataAccessException{
        //this makes it so the ui doesn't talk with data access layer this function will call the other function in the repo
        return repository.findBySection(section);
    }

    public Panel findBySectionRowCol(String section,int row,int col) throws DataAccessException{
        //this makes it so the ui doesn't talk with data access layer this function will call the other function in the repo
        return repository.findBySectionRowCol(section,row,col);
    }

    public PanelResult add(Panel panel) throws DataAccessException{
        // this passes panel to validateInputs
        // and it puts it through all of it's checks and adds the issues to messages
        addOrUpdate = "add";
        PanelResult result = validateInputs(panel,addOrUpdate); // this returns a PanelResult instance that will have any errors
        if(!result.isSuccess()){ // if the isSuccess() boolean from PanelResult is false there are issues
            return result; // return the error messages gathered
        }
        Panel p = repository.add(panel);// if it all checks out add the panel to the txt file and return the added panel
        result.setPayload(p); // take the panel that was added and put it on the result instance
        return result; // this will be just the instance of PanelResult with no messages
    }

    public PanelResult update(Panel panel) throws DataAccessException{
        addOrUpdate = "update";
        PanelResult result = validateInputs(panel,addOrUpdate); // runs the update data through validateInputs
        if(!result.isSuccess()){ // if there are no error messages
            return result; // return the instance of PanelResult with error messages
        }
        boolean success = repository.update(panel);
        if(!success){
            result.addErrorMessage("Could not update Panel " + panel.getSection() + "| Row: " + panel.getRow() + "| Col: " + panel.getColumn());
        }
        result.setPayload(panel);
        return result;
    }

    public PanelResult deleteBySectionRowCol(String section,int row, int col) throws DataAccessException{
        PanelResult result = new PanelResult();
        Boolean foundPanel = false;
        Panel panel = new Panel(); //this is an empty panel so we can use it later
        List<Panel> all = repository.findAll();
        for(int i=0; i<all.size(); i++){ // we need i for the index location of the panel in the List all
            if(all.get(i).getSection().equals(section) && all.get(i).getRow() == row
                    && all.get(i).getColumn() == col){
                foundPanel = true;
                panel = all.get(i);
                // this goes to the index of i and changes it to panel's info
            }
        }
        if(foundPanel){
            boolean success = repository.deleteBySectionRowCol(section,row,col);
            if(!success){
                result.addErrorMessage("Could not delete Panel " + panel.getSection() + "| Row: " + panel.getRow() + "| Col: " + panel.getColumn());
            }
        }else{
            result.addErrorMessage("Could not find Panel " + panel.getSection() + "| Row: " + panel.getRow() + "| Col: " + panel.getColumn());
        }
        result.setPayload(panel);
        return result;
    }

    private PanelResult validateInputs(Panel panel,String addOrUpdate) throws DataAccessException {
        // this is taking the inputs and adding any error messages needed to result

        PanelResult result = new PanelResult();
        if(panel == null){
            result.addErrorMessage("Panel cannot be null");
            return result;
        }
        //Section is required and cannot be blank
        if(panel.getSection() == null || panel.getSection().trim().length() == 0){
            result.addErrorMessage("Section is required");
        }
        //Row is a positive number less than or equal to 250.
        if(panel.getRow() <= 0 || panel.getRow() >= 250){
            result.addErrorMessage("Row number must be between 1 and 250");
        }
        //Column is a positive number less than or equal to 250.
        if(panel.getColumn() <= 0 || panel.getColumn() >= 250){
            result.addErrorMessage("Column number must be between 1 and 250");
        }
        //Year Installed must be in the past.
        int currentYear = LocalDate.now().getYear();
        if(panel.getYear() > currentYear){
            result.addErrorMessage("Year cannot be greater than " + currentYear);
        }
        //Material is required and can only be one of the five materials listed.
        MaterialType currentMaterial = panel.getMaterial();
        for (MaterialType material : MaterialType.values()) {
            switch(currentMaterial) {
                case MONOCRYSTALLINE_SILICON:
                case MULTICRYSTALLINE_SILICON:
                case AMORPHOUS_SILICON:
                case CADMIUM_TELLURIDE:
                case COPPER_INDIUM_GALLIUM_SELENIDE:
                    break;
                default:
                    result.addErrorMessage("Material must be: MONOCRYSTALLINE_SILICON, MULTICRYSTALLINE_SILICON, AMORPHOUS_SILICON, CADMIUM_TELLURIDE, or COPPER_INDIUM_GALLIUM_SELENIDE");
            }
        }
        //Is Tracking is required View checks for tracking to make sure it's entered
//        if(!panel.isTracking()){
//            result.addErrorMessage("Tracking is required");
//        }
        // The combined values of Section, Row, and Column may not be duplicated.
        List<Panel> allPanels = repository.findAll();
        if(addOrUpdate.equals("add")){
            for(Panel p : allPanels){
                if (panel.getSection().equals(p.getSection()) && panel.getRow() == p.getRow()
                        && panel.getColumn() == p.getColumn()) {
                    result.addErrorMessage("Section, row, and column cannot all be the same");
                }
            }
        }else if(addOrUpdate.equals("update")){
            boolean panelExists = false;
            for(Panel p : allPanels){
                if (panel.getSection().equals(p.getSection()) && panel.getRow() == p.getRow()
                        && panel.getColumn() == p.getColumn()) {
                    panelExists = true;
                }
            }
            if(!panelExists){
                result.addErrorMessage("Nothing to update");
            }
        }
        return result;
    }
}
