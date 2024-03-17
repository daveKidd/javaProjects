package videogames.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import videogames.models.Console;
import videogames.domain.ConsoleService;

@RestController
@CrossOrigin(origins = {"whatever.com", "https://hackerssuck.com"})
@RequestMapping("/api/console")
public class ConsoleController {
    private final ConsoleService service;

    public ConsoleController(ConsoleService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Console> findById(@PathVariable int id){
        Console console = service.findById(id);
        if(console != null){
            return new ResponseEntity<>(console, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}