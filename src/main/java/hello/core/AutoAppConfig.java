package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // basePackages = "hello.core.member", 탐색할 패지지의 시작 위치 지정 이 패키지 포함 하위 패키지를 모두 탐색
        // basePackageClasses = AutoAppConfig.class,
        // 지정하지 않으면 (기본값) package를 기준으로 하위 패키지를 모두 탐색 (프로젝트 최상단으로 지정)
        // 기존 AppConfig 클래스를 살려두기 위해서 excludeFilters 적용
        // @Configuration 제외 이유 -> @ComponentScan 존재 -> 스캔 대상
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
