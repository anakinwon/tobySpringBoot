package ankain.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

// 테스트 시 서버를 기동하는 옵션.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HelloApiTest {
    // 서버를 기동하고 테스트해야 한다
    // 서버 기동 후 테스트 진행 때문에, 느리다.
    @Test
    void helloApi(){
        // http localhost:8080/hello?name=spring
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res = rest.getForEntity("http://localhost:9090/app/hello?name={name}", String.class, "Spring");

        // status = 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        // header =(context-type) text/plain
        //assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).isEqualTo(MediaType.TEXT_PLAIN_VALUE);
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body = hello Spring
        assertThat(res.getBody()).isEqualTo("Hello *Spring*");

    }

    @Test
    void failsHelloApi(){
        // 서버를 기동하고 테스트를 진행하기 때문에, 느리다.
        // http localhost:8080/hello?name=spring
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res = rest.getForEntity("http://localhost:9090/app/hello?name=", String.class);

        // status = 500
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
