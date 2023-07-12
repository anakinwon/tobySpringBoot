package ankain.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *   <Starting embedded database>
 *    Starting embedded database:
 *       url='jdbc:h2:mem:1aa099b7-0003-4884-909d-1020ea331ba3;DB_CLOSE_DELAY=-1;
 *       DB_CLOSE_ON_EXIT=false', username='sa'
 * */
@JdbcTest   //
public class DataSourceTest {
    // 필드 주입
    @Autowired DataSource dataSource;

    @Test
    void connect() throws SQLException {
        Connection conn = dataSource.getConnection();
        conn.close();

    }
}
