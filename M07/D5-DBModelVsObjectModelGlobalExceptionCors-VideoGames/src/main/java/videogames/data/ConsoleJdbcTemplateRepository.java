package videogames.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import videogames.models.Console;
import videogames.models.VideoGame;

import java.util.List;

@Repository
public class ConsoleJdbcTemplateRepository implements ConsoleRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Console> consoleMapper = (rs, i) -> {
        return new Console(
                rs.getInt("console_id"),
                rs.getString("name"));
    };

    private final RowMapper<VideoGame> videoGameMapper = (rs, i) -> {
        return new VideoGame(
                rs.getInt("video_game_id"),
                rs.getString("title"),
                rs.getBigDecimal("price"),
                rs.getDate("release_date").toLocalDate(),
                rs.getBoolean("single_player"),
                rs.getInt("console_id"));
    };

    public ConsoleJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Console> findAll() {
        return null;
    }

    @Override
    @Transactional
    public Console findById(int consoleId) {
        final String sql =
                """
                select console_id, name from console where console_id = ?;
                """;

        Console result = jdbcTemplate.query(sql, consoleMapper, consoleId).stream()
                .findAny().orElse(null);

        if(result != null){
            addVideoGames(result);
        }
        return result;
    }

    private void addVideoGames(Console console){
        final String sql =
                """
                select video_game_id, title, price, release_date, single_player, console_id
                from video_game
                where console_id = ?;
                """;
        List<VideoGame> videoGames = jdbcTemplate.query(sql, videoGameMapper, console.getId());
        console.setVideoGames(videoGames);
    }

    @Override
    public Console create(Console console) {
        return null;
    }

    @Override
    public boolean update(Console console) {
        return false;
    }

    @Override
    public boolean deleteById(int consoleId) {
        return false;
    }
}
