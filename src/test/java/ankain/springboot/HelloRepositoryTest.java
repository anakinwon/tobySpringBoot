package ankain.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


// 테스트를 진행하는 동안 컨테이너 웹환경을 로딩할 필요가 없게 만드는 옵션
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {
    @Autowired HelloRepository helloRepository;
    @Autowired JdbcTemplate jdbcTemplate;

//    @Test
//    void findHelloFalied() {
//        assertThat(helloRepository.findHello("anakin")).isNull();
//    }

    @Test
    void increaseCount() {
        int helloCnt = helloRepository.countOf("anakin");
        System.out.println("0. helloCnt = " + helloCnt);
        assertThat(helloRepository.countOf("anakin")).isEqualTo(0);

        helloRepository.increaseCount("anakin");
        helloCnt = helloRepository.countOf("anakin");
        System.out.println("\t1. helloCnt = " + helloCnt);
        assertThat(helloRepository.countOf("anakin")).isEqualTo(1);

        helloRepository.increaseCount("anakin");
        helloCnt = helloRepository.countOf("anakin");
        System.out.println("\t\t2. helloCnt = " + helloCnt);
        assertThat(helloRepository.countOf("anakin")).isEqualTo(2);

    }

}
