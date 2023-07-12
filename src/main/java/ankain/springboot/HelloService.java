package ankain.springboot;

public interface HelloService {

    String sayHello(String name);

    // 추상메소드가 1개 이상이면 람다를 쓸 수 없을때
    // 아래와 같이 default. 메소드로 만들어 준다.
    default int countOf(String name)  {
        return 0;
    };

}
