package learn.solarpanels;

import learn.solarpanels.data.PanelFileRepository;
import learn.solarpanels.domain.PanelService;
import learn.solarpanels.ui.Controller;
import learn.solarpanels.ui.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@PropertySource("classpath:data.properties")
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        Controller controller = context.getBean(Controller.class);
        controller.run();


// replaced by annotations
//        PanelFileRepository repository = new PanelFileRepository("./data/solarpanels.txt"); // the prod version
//        PanelService service = new PanelService(repository);
//
//        View view = new View();
//
//        Controller controller = new Controller(service,view);
//        controller.run();
    }
}
