package ankain.springboot;

public interface HelloRepository {
    Hello findHello(String name) ;

    /** 카운트 증가시키키 */
    void increaseCount(String name);

    /** 카운트 가져오기 
     *    default 메소드 : 1.8에 추가됨
     * */
    default int countOf(String name) {
        Hello hello =findHello(name);
        return hello == null ? 0 : hello.getCount();
    }

}
