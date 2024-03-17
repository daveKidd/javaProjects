package rps.players;

public class FixedPlayer implements Player {

    private final int shotType;

    public FixedPlayer(int shotType) {
        this.shotType = shotType;
    }

    @Override
    public int shoot() {
        return shotType;
    }
}
