package hello.core.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(StatefulService.class);
        StatefulService bean1 = ac.getBean(StatefulService.class);
        StatefulService bean2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        int userA = bean1.order("userA", 10000);
        //ThreadB: B사용자 20000원 주문
        int userB = bean2.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
        //int price = bean1.getPrice();
        //System.out.println("price = " + price);
        System.out.println("price = " + userA);

//        Assertions.assertThat(bean1.getPrice()).isEqualTo(20000);
        Assertions.assertThat(userA).isEqualTo(10000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}