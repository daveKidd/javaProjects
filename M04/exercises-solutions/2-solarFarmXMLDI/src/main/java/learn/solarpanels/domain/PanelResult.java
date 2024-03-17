package learn.solarpanels.domain;

import learn.solarpanels.models.Panel;

import java.util.ArrayList;
import java.util.List;

public class PanelResult {

    private ArrayList<String> messages = new ArrayList<>();
    private Panel payload;

    public void addErrorMessage(String message){
        messages.add(message);
    }

    public boolean isSuccess(){
        return messages.size() == 0; //if there are no messages it will return true
    }
    public Panel getPayload() {
        return payload; // the getter of payload
    }
    public void setPayload(Panel payload){
        this.payload = payload; // the setter of payload
    }
    public List<String> getMessages(){
        return new ArrayList<>(messages); // the getter for messages (all the error messages)
    }
}
