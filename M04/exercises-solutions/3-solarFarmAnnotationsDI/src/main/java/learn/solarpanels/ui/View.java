package learn.solarpanels.ui;

import learn.solarpanels.domain.PanelResult;
import learn.solarpanels.models.MaterialType;
import learn.solarpanels.models.Panel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class View {
    private final Scanner console = new Scanner(System.in);

    public MenuOption displayMenuAndSelect(){
        MenuOption[] values = MenuOption.values(); // all the values in MenuOption enum
        printHeader("Welcome to the Solar Farm"); //prints out transformed header
        for(int i = 0; i < values.length; i++){ // loops through all the values in the enum
            System.out.printf("%s. %s%n",i,values[i].getTitle()); // prints out the number and title of each enum
        }
        // after millions of function calls this is the user input (number choice) that was checked for empty, valid number, and min max
        int index = readInt("Select 0-4: ",0,4);
        return values[index]; //this chooses the correct menu option after being checked for everything
    }

    public String getPanelSection(){
        String panel = readRequiredString("Section: ");
        return panel;
    }

    public void displayPanels(List<Panel> panels){
        printHeader("Selected panel section: " + panels.get(0).getSection());
        if(panels.size() == 0){
            System.out.println("Panel section not found");
        }else{
            String materialType = "";

            System.out.println("Row  Col  Year  Material   Tracking");
            for(Panel p : panels){
                switch(p.getMaterial()){
                    case AMORPHOUS_SILICON:
                        materialType= "AMSI";
                        break;
                    case CADMIUM_TELLURIDE:
                        materialType = "CATE";
                        break;
                    case MULTICRYSTALLINE_SILICON:
                        materialType = "MUSI";
                        break;
                    case COPPER_INDIUM_GALLIUM_SELENIDE:
                        materialType = "CIGS";
                        break;
                    case MONOCRYSTALLINE_SILICON:
                        materialType = "MOSI";
                        break;
                }
                //1st num - space between row and col 2 - col and year
                System.out.printf("%-4s %-4s %-5s %-10s %s%n",p.getRow(),p.getColumn(),p.getYear(),materialType,p.isTracking() == true ? "yes":"no");
            }
        }
    }

    public Panel makePanel(){
        Panel panel = new Panel();
        panel.setSection(readRequiredString("Section: "));
        panel.setRow(readInt("Row number: ",1,250));
        panel.setColumn(readInt("Column number: ",1,250));
        panel.setYear(readInt("Year installed: "));
        panel.setMaterial(readMaterialType());
        panel.setTracking(readTracking());

        return panel;
    }

    public MaterialType readMaterialType(){
        System.out.println("Pick Material: ");
        MaterialType[] values = MaterialType.values();
        for(int i=0; i< values.length; i++){
            System.out.printf("%s. %s%n",i,values[i]);
        }
        int index = readInt("Select [0-4]: ",0,4);
        return values[index];
    }

    public boolean readTracking(){
        int choice = readInt("Tracked? [0 - no  1 - yes]: ",0,1);
        if(choice == 1){
            return true;
        }else{
            return false;
        }
    }
    public void displayResult(PanelResult result,String which){
        if(result.isSuccess()){
            printHeader("Success!");
            switch(which){
                case "add":
                    System.out.println(result.getPayload().getSection() + "-" + result.getPayload().getRow() + "-" + result.getPayload().getColumn() + " added");
                    break;
                case "update":
                    System.out.println(result.getPayload().getSection() + "-" + result.getPayload().getRow() + "-" + result.getPayload().getColumn() + " updated");
                    break;
                case "delete":
                    System.out.println(result.getPayload().getSection() + "-" + result.getPayload().getRow() + "-" + result.getPayload().getColumn() + " deleted");
                    break;
            }
        }else{
            printHeader("Error!");
            for(String e: result.getMessages()){
                System.out.println(e);
            }
        }
    }

    public Panel getSectionRowCol(){
        Panel panel = new Panel();
        panel.setSection(readRequiredString("Section: "));
        panel.setRow(readInt("Row number: ",1,250));
        panel.setColumn(readInt("Column number: ",1,250));
        return panel;
    }

    public Panel update(Panel panel){
        System.out.printf("Editing: %s-%s-%s %n%n",panel.getSection(),panel.getRow(),panel.getColumn());

        System.out.println("Section: " + panel.getSection());
        System.out.println("Row: " + panel.getRow());
        System.out.println("Column: " + panel.getColumn());

        System.out.println("Material: " + panel.getMaterial());
        MaterialType material = readMaterialType();
        panel.setMaterial(material);

        int year = readInt("Installation Year (" + panel.getYear() +"): ");
        panel.setYear(year);

        System.out.println("Tracking: " + panel.isTracking());
        boolean tracking = readTracking();
        panel.setTracking(tracking);

        return panel;
    }

    public void printHeader(String message){
        System.out.println();
        System.out.println(message);
        System.out.println("-".repeat(message.length()));
    }



    private int readInt(String prompt, int min, int max){ // checks to see if user input is between min and max
        int result = 0;
        do{
            result = readInt(prompt); // line 43
            if(result < min || result > max){
                System.out.printf("Value must be between %s and %s.%n",min,max);
            }
        }while(result < min || result > max);

        return result;
    }

    private int readInt(String prompt){ // checks to see if user input from readString is a number
        int result = 0;
        boolean isValid = false;
        do{
            String value = readRequiredString(prompt); // line 60
            try{
                result = Integer.parseInt(value);
                isValid = true;
            }catch(NumberFormatException ex){
                System.out.println("Value must be a number");
            }

        }while(!isValid);

        return result;
    }

    private String readRequiredString(String prompt){ // checks to see if user input from readString is empty
        String result = null;
        do{
            result = readString(prompt).trim(); // line 71 returns console.nextLine(), the user input
            if(result.length() == 0){
                System.out.println("Value is required");
            }
        }while(result.length() == 0);
        return result;
    }

    private String readString(String prompt){
        System.out.print(prompt);
        return console.nextLine();
    }
}
