package videogames.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class VideoGame {
    private int id;
    private String title;
    private BigDecimal price;
    private LocalDate releaseDate;
    private boolean singlePlayer;
    private int consoleId;

    public VideoGame() {}

    public VideoGame(int id, String title, BigDecimal price, LocalDate releaseDate, boolean singlePlayer, int consoleId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.releaseDate = releaseDate;
        this.singlePlayer = singlePlayer;
        this.consoleId = consoleId;
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

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", singlePlayer=" + singlePlayer +
                ", consoleId=" + consoleId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoGame videoGame = (VideoGame) o;
        return id == videoGame.id && singlePlayer == videoGame.singlePlayer && consoleId == videoGame.consoleId && title.equals(videoGame.title) && price.equals(videoGame.price) && releaseDate.equals(videoGame.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, releaseDate, singlePlayer, consoleId);
    }
}
