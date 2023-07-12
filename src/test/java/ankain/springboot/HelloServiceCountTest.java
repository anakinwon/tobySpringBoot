package ankain.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;
import static org.assertj.core.api.Assertions.assertThat;

// 테스트를 진행하는 동안 컨테이너 웹환경을 로딩할 필요가 없게 만드는 옵션
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloServiceCountTest {
    @Autowired HelloService helloService;
    @Autowired HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount() {
        IntStream.rangeClosed(1,10).forEach(count -> {
            helloService.sayHello("anakin");
            assertThat(helloRepository.countOf("anakin")).isEqualTo(count);
        });
    }
}
