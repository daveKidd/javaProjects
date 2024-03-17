package videogames.domain;

import org.springframework.stereotype.Service;
import videogames.data.ConsoleRepository;
import videogames.models.Console;

import java.util.List;

@Service
public class ConsoleService {
    private final ConsoleRepository repository;

    public ConsoleService(ConsoleRepository repository) {
        this.repository = repository;
    }

    public List<Console> findAll() {
        return repository.findAll();
    }

    public Console findById(int id) {
        return repository.findById(id);
    }
}
