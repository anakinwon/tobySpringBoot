package ankain.study;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ConfigurationTest {

    @Test
    void configuration() {
        //===============================================================================
        // 주소는 다르게 테스트 결과가 나옴.
        assertThat(new Common()).isNotEqualTo(new Common());

        //===============================================================================
        // 값은 같게 테스트 결과가 나옴.
        Common common = new Common();
        assertThat(common).isEqualTo(common);

        //===============================================================================
        MyConfig myConfig = new MyConfig();
        Bean1 bean1 = myConfig.bean1();
        Bean2 bean2 = myConfig.bean2();
        // 같지 않음
        assertThat(bean1.common).isNotEqualTo(bean2.common);

        //===============================================================================
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();

        Bean1 bean11 = ac.getBean(Bean1.class);
        Bean2 bean22 = ac.getBean(Bean2.class);

        // 왜 같게 나오나?
        assertThat(bean11.common).isSameAs(bean22.common);
    }

    @Test
    void proxyCommonMethod() {
        MyConfigProxy myConfigProxy = new MyConfigProxy();

        Bean1 bean1 = myConfigProxy.bean1();
        Bean2 bean2 = myConfigProxy.bean2();

        // 테스트 결과 같게 나오면 정상.
        assertThat(bean1.common).isSameAs(bean2.common);

    }

    //==============================================================================
    //==============================================================================

    static class MyConfigProxy extends MyConfig {
        private Common common;
        @Override
        Common common() {
            if (this.common==null)
                this.common = super.common();
            return this.common; // null 이 아니면 캐싱한다.
        }
    }




    // Bean1   <-  Common
    // Bean2   <-  Common
    @Configuration
    static class MyConfig {
        @Bean
        Common common() {
            return new Common();
        }
        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }
        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }
    }

    static class Common {

    }
    static class Bean1 {
        private final Common common;
        public Bean1(Common common) {
            this.common = common;
        }
    }
    static class Bean2 {
        private final Common common;
        public Bean2(Common common) {
            this.common = common;
        }
    }

}
