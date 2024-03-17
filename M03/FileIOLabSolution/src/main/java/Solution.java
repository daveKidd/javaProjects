import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./data/README.txt"));
        for (String line : lines) {
            processLine(line);
        }
    }

    static void processLine(String line) throws IOException {
        if (line.startsWith("CREATE")) {
            create(line);
        } else if (line.startsWith("APPEND")) {
            append(line);
        } else if (line.startsWith("DELETE")) {
            delete(line);
        } else if (line.startsWith("COPY")) {
            copy(line);
        }
    }

    static void create(String line) throws IOException {
        int firstSpace = line.indexOf(' ');
        File file = new File(line.substring(firstSpace + 1));
        file.createNewFile();
    }

    static void append(String line) throws IOException {
        int firstSpace = line.indexOf(' ');
        int secondSpace = line.indexOf(' ', firstSpace + 1);
        String path = line.substring(firstSpace + 1, secondSpace);
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.println(line.substring(secondSpace + 1));
        }
    }

    static void delete(String line) {
        int firstSpace = line.indexOf(' ');
        File file = new File(line.substring(firstSpace + 1));
        file.delete();
    }

    static void copy(String line) throws IOException {
        String[] tokens = line.split(" ");
        Path source = Paths.get(tokens[1]);
        Path destination = Paths.get(tokens[2]);
        if (tokens.length == 3) {
            Files.createDirectories(destination.getParent());
            String content = Files.readString(source);
            Files.writeString(destination, content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
    }
}
