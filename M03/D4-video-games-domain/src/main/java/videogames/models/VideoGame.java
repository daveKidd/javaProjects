package videogames.models;

import java.util.Objects;

public class VideoGame {
    private int id;
    private String title;
    private VideoGameConsole console;
    private double price;

    public VideoGame(int id, String title, VideoGameConsole console, double price) {
        this.id = id;
        this.title = title;
        this.console = console;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", console=" + console +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoGame videoGame = (VideoGame) o;
        return id == videoGame.id && Double.compare(videoGame.price, price) == 0 && title.equals(videoGame.title) && console == videoGame.console;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, console, price);
    }
}
