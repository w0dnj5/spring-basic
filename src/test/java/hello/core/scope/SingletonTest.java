package hello.core.scope;

import static org.assertj.core.api.Assertions.*;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingleTonBean.class);
        SingleTonBean bean1 = ac.getBean(SingleTonBean.class);
        SingleTonBean bean2 = ac.getBean(SingleTonBean.class);
        assertThat(bean1).isEqualTo(bean2);
        ac.close();
    }

    @Scope("singleton")
    static class SingleTonBean {

        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }
}
