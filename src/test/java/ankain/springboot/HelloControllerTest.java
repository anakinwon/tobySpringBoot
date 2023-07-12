package ankain.springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

// 단위테스트는 애노테이션 필요 업다.
public class HelloControllerTest {

    // 서버 기동 안해도 된다.
    // 고립된 테스트가 가능해서,
    // 정상 테스트
    @Test
    void helloController() {
        HelloController helloController = new HelloController(name -> name);

        // 단위테스트 1 : 정상값 테스트
        String result = helloController.hello("Test");
        assertThat(result).isEqualTo("Test");
    }

    // 비정상 테스트
    @Test
    void failHelloController() {
        HelloController helloController = new HelloController(name -> name);

        // 단위테스트 2 :  null 체크 테스트
        assertThatThrownBy(()-> {
            String ret = helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        // 단위테스트 3 :  빈 문자열 체크 테스트
        assertThatThrownBy(()-> {
            helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
