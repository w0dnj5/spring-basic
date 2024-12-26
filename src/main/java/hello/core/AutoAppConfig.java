package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
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
/*
// 컴포넌트 스캔에 의해 자동으로 스프링 빈이 등록되는데, 그 이름이 같은 경우 스프링은 오류를 발생시킨다.
// spring.main.allow-bean-definition-overriding=true 로 설정 시 수동으로 설정한 Bean이 자동 등록한 Bean을 Override 한다.
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
*/
}
