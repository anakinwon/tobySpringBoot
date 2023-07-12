package ankain.springboot;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// 단위테스트는 애노테이션 필요 업다.
public class HelloServiceTest {

    // 서버 기동 안해도 된다.
    // 고립된 테스트가 가능해서,
    // 엄청 빠르다.
    @Test
    void simpleHelloService() {
//        SimpleHelloService helloService = new SimpleHelloService();
//        String ret = helloService.sayHello("Test");
//        assertThat(ret).isEqualTo("Hello Test");
        SimpleHelloService helloService = new SimpleHelloService(helloRepository);
        String ret = helloService.sayHello("Test");
        assertThat(ret).isEqualTo("Hello Test");
    }

    private static HelloRepository helloRepository = new HelloRepository() {
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {
        }
    };
}
