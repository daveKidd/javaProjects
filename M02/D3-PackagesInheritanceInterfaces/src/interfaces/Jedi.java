package interfaces;

public class Jedi implements ForceUser{

    @Override
    public void wieldLightSaber() {
        System.out.println("The Jedi cuts open a jar for Grandma");
    }

    @Override
    public void forcePush() {
        System.out.println("The Jedi forces pushes Grandma out of the street");
    }
}
