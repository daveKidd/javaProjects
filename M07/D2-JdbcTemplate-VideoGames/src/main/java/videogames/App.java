package videogames;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import videogames.data.DataAccessException;
import videogames.data.VideoGameFileRepository;
import videogames.domain.VideoGameService;
import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;
import videogames.ui.Controller;
import videogames.ui.View;

import java.util.List;

@ComponentScan
@PropertySource("classpath:data.properties")
public class App {
    public static void main(String[] args) throws DataAccessException {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        Controller controller = context.getBean(Controller.class);
        controller.run();
    }
}
