package learn.solarpanels.ui;

import learn.solarpanels.data.DataAccessException;
import learn.solarpanels.domain.PanelResult;
import learn.solarpanels.domain.PanelService;
import learn.solarpanels.models.MaterialType;
import learn.solarpanels.models.Panel;

import java.util.List;

public class Controller {
    private final PanelService service;
    private final View view;

    public Controller(PanelService service, View view){
        this.service = service;
        this.view = view;
    }

    public void run(){
        try{
            runMenu();
        }catch(DataAccessException ex){
            view.printHeader("Fatal error: " + ex);
        }
    }

    private void runMenu() throws DataAccessException {
        MenuOption option;
        do{
            option = view.displayMenuAndSelect();

            switch(option){
                case EXIT:
                    view.printHeader("Buh Bye!");
                    break;
                case DISPLAY_PANELS_BY_SECTION:
                    displayPanelsBySection();
                    break;
                case CREATE_PANEL:
                    createPanel();
                    break;
                case UPDATE_PANEL:
                    updatePanel();
                    break;
                case DELETE_PANEL:
                    deletePanel();
                    break;
            }
        }while(option != MenuOption.EXIT);
    }

    private void displayPanelsBySection() throws DataAccessException {
        view.printHeader(MenuOption.DISPLAY_PANELS_BY_SECTION.getTitle());
        String panelSection = view.getPanelSection();
        List<Panel> panels = service.findBySection(panelSection);
        view.displayPanels(panels);
    }

    private void createPanel() throws DataAccessException {
        view.printHeader(MenuOption.CREATE_PANEL.getTitle());
        Panel panel = view.makePanel();
        PanelResult result = service.add(panel);
        view.displayResult(result,"add");
    }

    private void updatePanel() throws DataAccessException {
        view.printHeader(MenuOption.UPDATE_PANEL.getTitle());
        Panel panelInfo = view.getSectionRowCol();
        Panel foundPanel = service.findBySectionRowCol(panelInfo.getSection(),panelInfo.getRow(),panelInfo.getColumn());
        Panel panel = view.update(foundPanel);
        PanelResult result = service.update(panel);
        view.displayResult(result,"update");
    }

    private void deletePanel() throws DataAccessException {
        view.printHeader(MenuOption.DELETE_PANEL.getTitle());
        Panel panelInfo = view.getSectionRowCol();
        PanelResult result = service.deleteBySectionRowCol(panelInfo.getSection(),panelInfo.getRow(),panelInfo.getColumn());
        view.displayResult(result,"delete");
    }
}
