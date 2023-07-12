package ankain.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final HelloService helloService;

    @Autowired   // 생성자를 통해서 주입을 할 때 후보를 찾아와서 자동으로 연결해 달라
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/app/hello")
//    @ResponseBody   // @RestController 없을 때 view 페이지 반환 오류 해결 방법
    public String hello(String name) {
        if (name==null || name.trim().length()==0) throw new IllegalArgumentException();
        //return helloService.sayHello(Objects.requireNonNull(name));
        return helloService.sayHello(name);
    }

    @GetMapping("/count")
    public String countOf(String name) {
        return name+ " = " + helloService.countOf(name);
    }

}
