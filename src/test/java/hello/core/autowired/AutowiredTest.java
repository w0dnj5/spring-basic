package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest {

    @Test
    void autowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {

        // 메소드 자체가 호출 x
        @Autowired(required = false)
        public void setNoBean1(Member noBean) {
            System.out.println("noBean1 = " + noBean);
        }

        // 호출되지만 null이 들어옴
        @Autowired
        public void setNoBean2(@Nullable Member noBean) {
            System.out.println("noBean2 = " + noBean);
        }

        // Option.empty 
        @Autowired
        public void setNoBean3(Optional<Member> noBean) {
            System.out.println("noBean3 = " + noBean);
        }
    }
}
