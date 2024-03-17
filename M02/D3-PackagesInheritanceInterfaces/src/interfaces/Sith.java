package interfaces;

public class Sith implements ForceUser, SithPowers{
    @Override
    public void wieldLightSaber() {
        System.out.println("The naughty Sith cuts down a tree");
    }

    @Override
    public void forcePush() {
        System.out.println("The naughty Sith force pushes a flower");
    }

    @Override
    public void forceLigthning() {
        System.out.printf("The naughty Sith shot lightning for %s",forceLightningPower);
    }
}
