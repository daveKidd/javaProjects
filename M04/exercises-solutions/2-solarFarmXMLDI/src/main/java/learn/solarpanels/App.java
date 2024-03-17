package learn.solarpanels;

import learn.solarpanels.data.PanelFileRepository;
import learn.solarpanels.domain.PanelService;
import learn.solarpanels.ui.Controller;
import learn.solarpanels.ui.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependency-config.xml");
        Controller controller = context.getBean(Controller.class);
        controller.run();

        /* replaced with XML DI above
        PanelFileRepository repository = new PanelFileRepository("./data/solarpanels.txt"); // the prod version
        PanelService service = new PanelService(repository);

        View view = new View();

        Controller controller = new Controller(service,view);
        controller.run();

         */
    }
}
