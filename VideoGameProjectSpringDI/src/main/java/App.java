import backToTheFuture.Character;
import backToTheFuture.Quote;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-config.xml");
        Character docBrown = context.getBean("docBrown",Character.class);
        Character docBrown2 = context.getBean("docBrown",Character.class);
        Quote greatScott = context.getBean("greatScott",Quote.class);
        System.out.println(greatScott);

        Quote thatsHeavy = context.getBean("thatsHeavy",Quote.class);
        System.out.println(thatsHeavy);

        Quote docBrownBest = context.getBean("docBrownBest",Quote.class);
        System.out.println(docBrownBest);


//        System.out.println("First: " + docBrown);
//        System.out.println("Second: " + docBrown2);
//        docBrown.setVersion(1985);
//        System.out.println("First: " + docBrown);
//        System.out.println("Second: " + docBrown2);


//        Character martyMcfly = context.getBean("martyMcfly",Character.class);
//        System.out.println(docBrown);
//        System.out.println(martyMcfly);
    }
}
