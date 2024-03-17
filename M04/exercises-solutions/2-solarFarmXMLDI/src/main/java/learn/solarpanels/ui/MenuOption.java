package learn.solarpanels.ui;

public enum MenuOption {
    EXIT("Exit"),
    DISPLAY_PANELS_BY_SECTION("Find Panels by Section"),
    CREATE_PANEL("Create Panel"),
    UPDATE_PANEL("Update Panel"),
    DELETE_PANEL("Delete Panel");
    private final String title;

    MenuOption(String title) {
        this.title = title;
    } // this creates a title out of each option above

    public String getTitle() {
        return title;
    }
}
