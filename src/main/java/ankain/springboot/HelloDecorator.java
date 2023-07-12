package ankain.springboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary  // Parameter 0 of constructor in ankain.springboot.HelloController required a single bean, but 2 were found:
public class HelloDecorator implements HelloService {
    private final HelloService helloService;
    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        return helloService.sayHello(name);
    }

    @Override
    public int countOf(String name) {
        return helloService.countOf(name);
    }

}

