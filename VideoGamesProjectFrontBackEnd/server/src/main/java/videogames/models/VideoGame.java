package videogames.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class VideoGame {
    private int id;
    private String title;
    private VideoGameConsole console;
    private BigDecimal price;
    private LocalDate releaseDate;
    private boolean singlePlayer;

    public VideoGame() {}

    public VideoGame(int id, String title, VideoGameConsole console, BigDecimal price,
                     LocalDate releaseDate, boolean singlePlayer) {
        this.id = id;
        this.title = title;
        this.console = console;
        this.price = price;
        this.releaseDate = releaseDate;
        this.singlePlayer = singlePlayer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public VideoGameConsole getConsole() {
        return console;
    }

    public void setConsole(VideoGameConsole console) {
        this.console = console;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isSinglePlayer() {
        return singlePlayer;
    }

    public void setSinglePlayer(boolean singlePlayer) {
        this.singlePlayer = singlePlayer;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", console=" + console +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", singlePlayer=" + singlePlayer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoGame game = (VideoGame) o;
        return id == game.id && singlePlayer == game.singlePlayer && title.equals(game.title) && console == game.console && price.equals(game.price) && releaseDate.equals(game.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, console, price, releaseDate, singlePlayer);
    }
}
