package learn;

public class VideoGame {
    private final String title;
    private final int yearReleased;
    private final int players;
    private final String category;

    public VideoGame(String title, int yearReleased, int players, String category) {
        this.title = title;
        this.yearReleased = yearReleased;
        this.players = players;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public int getPlayers() {
        return players;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "title='" + title + '\'' +
                ", yearReleased=" + yearReleased +
                ", players=" + players +
                ", category='" + category + '\'' +
                '}';
    }
}
