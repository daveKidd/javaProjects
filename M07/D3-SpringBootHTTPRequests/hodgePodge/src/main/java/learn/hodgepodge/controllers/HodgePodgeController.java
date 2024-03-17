package learn.hodgepodge.controllers;

import learn.hodgepodge.models.SheepValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HodgePodgeController {
    /*
    1 - My Name
    Return your name as a string.

    HTTP Method: GET
    Path: /name
    Input: None
    Output: your name (String)
     */

    @GetMapping("/name")
    public String myName(){
        return "Dave";
    }

    /*
    2 - What Time is it?
    Return the current date and time.

    HTTP Method: GET
    Path: /current/time
    Input: None
    Output: LocalDateTime.now()
     */
    @GetMapping("/current/time")
    public LocalDateTime currentTime(){
        return LocalDateTime.now();
    }

    /*
    3 - Greeting
    Return a greeting that's customized for a name passed in the URL.

    Example: "Hello, Dr. Itch!"

    HTTP Method: GET
    Path: /greet/{name}
    Input: @PathVariable String name
    Output: String
    */
    @GetMapping("/greet/{name}")
    public String getGreeting(@PathVariable String name){
        return String.format("Hello, %s!",name);
    }

    /*
    4 - Counting Sheep
    Create a static integer named sheepCount in the controller class. Each time the handler method is activated, increment its value by one.

    HTTP Method: PUT
    Path: /sheep
    Input: None
    Output: None
    */
    int sheepCount = 0;

    @PutMapping("/sheep")
    public void countSheep(){
        sheepCount++;
    }

    /*
    5 - How Many Sheep?
    Return the number of sheep -- sheepCount.

    HTTP Method: GET
    Path: /sheep
    Input: None
    Output: sheepCount
    */

    @GetMapping("/sheep")
    public int getGreeting(){
        return sheepCount;
    }

    /*
    6 - Increase Sheep By Amount
    Use sheepCount. Each time the handler method is activated, increase its value by the amount provided.

    HTTP Method: PUT
    Path: /sheep/{amount}
    Input: @PathVariable int amount
    Output: None
    */
    @PutMapping("/sheep/{amount}")
    public void getGreeting(@PathVariable int amount){
        sheepCount += amount;
    }


    /*
    7 - Increase Sheep With Object
    Create a class, SheepValue.

    public class SheepValue {

        private int amount;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }
    Each time the handler method is activated, increase sheepCount by the amount in SheepValue.getAmount.

    HTTP Method: POST
    Path: /sheep
    Input: @RequestBody SheepValue value
    Output: None
    */
    @PostMapping("/sheep")
    public void increaseSheep(@RequestBody SheepValue obj){
        sheepCount += obj.getAmount();
    }

    /*
    8 - Lost Sheep
    Each time the handler method is activated, decrement sheepCount by one.

    HTTP Method: DELETE
    Path: /sheep
    Input: None
    Output: None
    */
    @DeleteMapping("/sheep")
    public void decreaseSheepCount(){
        sheepCount--;
    }

    /*
    9 - To-Dos
    Create a static ArrayList<String> todos in the controller. Populate the list with one or two To-Dos for today.

    Return the list.

    HTTP Method: GET
    Path: /todo
    Input: None
    Output: To-Dos as List<String>
    */
    ArrayList<String> todos = new ArrayList<>(List.of("Eat food", "Jump Around", "Sleep"));
    @GetMapping("/todo")
    public ArrayList<String> getTodos(){
        return todos;
    }

    /*
    10 - To-Do, Bulk Upload
    Append a list of To-Dos to todos.

    HTTP Method: PUT
    Path: /todo
    Input: @RequestBody List<String> items
    Output: None
    */
    @PutMapping("/todo")
    public void appendTodos(@RequestBody List<String> items){
        todos.addAll(items);
    }

    /*
    11 - Add One To-Do
    Add one To-Do to todos.

    HTTP Method: PUT
    Path: /todo/{item}
    Input: @PathVariable String item
    Output: None
    */
    @PutMapping("/todo/{item}")
    public void appendTodos(@PathVariable String item){
        todos.add(item);
    }


    /*
    12 - Delete A To-Do
    Remove the To-Do at the specified index. If it doesn't exist, return 404 Not Found. Otherwise, return 200 OK.

    HTTP Method: DELETE
    Path: /todo/{index}
    Input: @PathVariable int index
    Output: None
    */
    @DeleteMapping("/todo/{index}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int index) {
        if (index < 0 || index >= todos.size()) {
            //return ResponseEntity.notFound().build();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        todos.remove(index);
        return ResponseEntity.ok().build();
        //return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    /*
    13 - Replace To-Dos
    Replace the current todos with the list provided.

    HTTP Method: POST
    Path: /todo
    Input: @RequestBody List<String> items
    Output: None
     */

    @PostMapping("/todo")
    public void postTodos(@RequestBody ArrayList<String> items) {
        todos = items;
    }
}
