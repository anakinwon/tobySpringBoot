package ankain.springboot;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})  // ElementType.METHOD <= 메타 애노테이션 사용시 추가해야 함.
@Test
@interface UnitTest {
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@UnitTest
@interface FastUnitTest {
}

@SpringBootTest
public class MetaAnnotationTest {

    @FastUnitTest
    void fastUitTest() {
        System.out.println("중첩 메타 애노테이션 적용 Test()");
    }

    @UnitTest
    void unitTest() {
        System.out.println("메타 애노테이션 적용 Test()");
    }

    @Test
    void test() {
        System.out.println("일반 Test()");
    }

}
