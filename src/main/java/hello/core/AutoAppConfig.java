package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 기존 AppConfig 클래스를 살려두기 위해서 excludeFilters 적용
        // @Configuration 제외 이유 -> @ComponentScan 존재 -> 스캔 대상
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
