package videogames;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import videogames.data.DataAccessException;
import videogames.data.VideoGameFileRepository;
import videogames.data.VideoGameRepository;
import videogames.domain.VideoGameService;
import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;
import videogames.ui.Controller;
import videogames.ui.View;

import java.util.ArrayList;
import java.util.List;

@ComponentScan
@PropertySource("classpath:data.properties")
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        Controller controller = context.getBean(Controller.class);
        controller.run();

        /* XML
        ApplicationContext context = new ClassPathXmlApplicationContext("dependency-config.xml");

        Controller controller = context.getBean(Controller.class);
        controller.run();
        */

        /* Old lame non-spring way
        VideoGameRepository repository = new VideoGameFileRepository("./data/video-games.csv");
        VideoGameService service = new VideoGameService(repository);

        View view = new View();
        Controller controller = new Controller(view,service);

        controller.run();
        */
    }
}
