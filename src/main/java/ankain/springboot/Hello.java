package ankain.springboot;

public class Hello {
    String name;
    int count;

    public Hello(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }


    public int getCount() {
        return count;
    }

}
