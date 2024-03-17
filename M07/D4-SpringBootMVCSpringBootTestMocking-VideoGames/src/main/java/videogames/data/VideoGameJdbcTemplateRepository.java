package videogames.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class VideoGameJdbcTemplateRepository implements VideoGameRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<VideoGame> rowMapper = (rs, i) -> {
        return new VideoGame(
                rs.getInt("video_game_id"),
                rs.getString("title"),
                VideoGameConsole.valueOf(rs.getString("console")),
                rs.getBigDecimal("price"),
                rs.getDate("release_date").toLocalDate(),
                rs.getBoolean("single_player"));
    };

    public VideoGameJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<VideoGame> findAll() {
        final String sql = """
                select
                	video_game_id,
                    title,
                    console,
                    price,
                    release_date,
                    single_player
                from video_game;
                """;
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public VideoGame findById(int videoGameId) {
        final String sql = """
                select
                	video_game_id,
                    title,
                    console,
                    price,
                    release_date,
                    single_player
                from video_game
                where video_game_id = ?;
                """;

        return jdbcTemplate.query(sql, rowMapper, videoGameId).stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public VideoGame create(VideoGame videoGame) {
        final String sql = """
                insert into video_game (
                    title,
                    console,
                    price,
                    release_date,
                    single_player
                ) values (?, ?, ?, ?, ?);
                """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, videoGame.getTitle());
            ps.setString(2, videoGame.getConsole().toString());
            ps.setBigDecimal(3, videoGame.getPrice());
            ps.setDate(4, Date.valueOf(videoGame.getReleaseDate()));
            ps.setBoolean(5, videoGame.isSinglePlayer());
            return ps;
        }, keyHolder);

        if (rowsAffected == 0) {
            return null;
        }

        videoGame.setId(keyHolder.getKey().intValue());
        return videoGame;
    }

    @Override
    public boolean update(VideoGame videoGame) {
        final String sql = """
                update video_game set
                    title = ?,
                    console = ?,
                    price = ?,
                    release_date = ?,
                    single_player = ?
                where video_game_id = ?;
                """;
        int rowsAffected = jdbcTemplate.update(sql,
                videoGame.getTitle(),
                videoGame.getConsole().toString(),
                videoGame.getPrice(),
                videoGame.getReleaseDate(),
                videoGame.isSinglePlayer(),
                videoGame.getId());

        return rowsAffected > 0;
    }

    @Override
    public boolean deleteById(int videoGameId) {
        final String sql = "delete from video_game where video_game_id = ?;";
        return jdbcTemplate.update(sql, videoGameId) > 0;
    }
}
