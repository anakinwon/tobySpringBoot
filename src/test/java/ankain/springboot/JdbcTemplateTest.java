package ankain.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

@JdbcTest
@Rollback(value = false)
public class JdbcTemplateTest {
    @Autowired JdbcTemplate jdbcTemplate;

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("insert into hello values(?,?)", "anakin", 1);
        jdbcTemplate.update("insert into hello values(?,?)", "padme", 2);

        Long aLong = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        System.out.println("\n\n\t\t\t인사횟수 = " + aLong);
        
    }


}
