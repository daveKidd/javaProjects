package learn.solarpanels.models;

public class Panel {
    private String section;
    private int row;
    private int column;
    private int year;
    private MaterialType material;
    private boolean isTracking;

    public Panel(){

    }
    public Panel(String section, int row, int column, int year, MaterialType material, boolean isTracking){
        this.section = section;
        this.row = row;
        this.column = column;
        this.year = year;
        this.material = material;
        this.isTracking = isTracking;
    }

    public String getSection() {
        return section;
    }
    public void setSection(String section) {
        this.section = section;
    }

    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public MaterialType getMaterial() {
        return material;
    }
    public void setMaterial(MaterialType material) {
        this.material = material;
    }

    public boolean isTracking() {
        return isTracking;
    }
    public void setTracking(boolean tracking) {
        isTracking = tracking;
    }
}
