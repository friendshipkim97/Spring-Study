package spring.Tutorial1.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import spring.Tutorial1.member.Member;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{

        @Autowired(required = false)
        public void setNoBean1(Member noBean1){ // Member는 스프링 컨테이너에서 관리하는 게 아님!
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){ // Member는 스프링 컨테이너에서 관리하는 게 아님!
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){ // Optional은 값이 안에 없어도 Optional로 감싸서 넣음
            System.out.println("noBean3 = " + noBean3);
        }

    }

}
