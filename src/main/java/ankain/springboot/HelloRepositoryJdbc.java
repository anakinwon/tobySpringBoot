package ankain.springboot;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryJdbc implements HelloRepository {

    private final JdbcTemplate jdbcTemplate;

    public HelloRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Hello findHello(String name) {
        try {
            return jdbcTemplate.queryForObject("select * from hello where name = '" + name + "'",
                    (rs, rownum) -> new Hello(rs.getString("name"), rs.getInt("count"))
            );
        }
        catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void increaseCount(String name) {
        Hello hello = findHello(name);
        if (hello ==null)
            jdbcTemplate.update("insert into hello values (?,?)", name, 1);
        else
            jdbcTemplate.update("update hello set count = count+1 where name = ?", name);
    }
}
