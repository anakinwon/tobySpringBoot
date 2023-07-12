package ankain.springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloDecoratorTest {

    @Test
    void sayHelloDecoratorTest() {
        HelloDecorator decorator = new HelloDecorator(name -> name);
        String res = decorator.sayHello("Test");

        Assertions.assertThat(res).isEqualTo("*Test*");
    }
}