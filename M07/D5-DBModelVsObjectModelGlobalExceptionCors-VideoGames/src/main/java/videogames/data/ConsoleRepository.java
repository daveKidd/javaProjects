package videogames.data;

import videogames.models.Console;

import java.util.List;

public interface ConsoleRepository {
    List<Console> findAll();

    Console findById(int consoleId);

    Console create(Console console);

    boolean update(Console console);

    boolean deleteById(int consoleId);
}
