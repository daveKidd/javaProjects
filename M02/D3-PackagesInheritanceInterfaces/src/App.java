//import inheritance.Jedi;
import inheritance.Person;
import interfaces.ForceUser;
import interfaces.Sith;
import interfaces.Jedi;
import interfaces.SithPowers;

public class App {
    public static void main(String[] args) {
        //Interfaces
        ForceUser yoda = new Jedi();
        Sith vader = new Sith();

        yoda.forcePush();
        yoda.wieldLightSaber();
        vader.forcePush();
        vader.wieldLightSaber();
        vader.forceLigthning();

        // Inheritance stuff
//        Person dave = new Person("Dave",18);
//        System.out.println(dave.getName());
//        System.out.println(dave.getAge());
//        System.out.println(dave.speak("Steak is yummy"));
//
//        Jedi obi = new Jedi("Obi-Wan", 25, "blue", "Qui-Gon-Jinn");
//        System.out.println(obi.getSaberColor());
//        System.out.println(obi.getName());
//        System.out.println(obi.getAge());
//        System.out.println(obi.speak("Why hello there"));
//
//        obi.mindTrick(dave);

    }
}
