package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); // 하나만 만들어서 올라가짐

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){ // 생성자를 private으로 막아서 new로 생성할 수 있는 부분이 없게 됨
                                // 딱 1개의 객체 인스턴스만 생성이 되어야 하므로
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
