package videogames.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import videogames.domain.VideoGameResult;
import videogames.domain.VideoGameService;
import videogames.models.VideoGame;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/video-game")
public class VideoGameController {
    private final VideoGameService service;

    public VideoGameController(VideoGameService service) {
        this.service = service;
    }

    @GetMapping
    public List<VideoGame> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoGame> findById(@PathVariable int id){
        VideoGame game = service.findById(id);
        if(game != null){
            return new ResponseEntity<>(game, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody VideoGame videoGame){
        VideoGameResult result = service.create(videoGame);
        if(result.isSuccess()){
            return new ResponseEntity<>(result.getVideoGame(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result.getMessages(), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody VideoGame videoGame){
        if(id != videoGame.getId()){
            return new ResponseEntity<>("Not updating the correct game ):", HttpStatus.CONFLICT);
        }
        VideoGameResult result = service.update(videoGame);
        if(result.isSuccess()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result.getMessages(), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id){
        VideoGameResult result = service.deleteById(id);
        if(result.isSuccess()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(result.getMessages(), HttpStatus.BAD_REQUEST);
    }
}
