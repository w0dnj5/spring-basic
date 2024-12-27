package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    // 필드 주입 방식 (권장하지 않음 - 테스트하기 불편하다)
    //@Autowired
    private final MemberRepository memberRepository;
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //@Autowired
    private final DiscountPolicy discountPolicy;
/*
    // 생성자가 하나만 있다면 @Autowired 생략 가능
    // 생성자 주입 장점
    // - 개발자 실수를 줄여줌
    // - 불필요한 호출을 방지할 수 있음
    // - 테스트 시 유연하게 테스트 가능
    // - 프레임워크 의존하지 않고 순수한 자바 언어의 특징을 잘 살리는 방법이기도 함
    // - 우선 순위 1. 생성자 주입 방식, 2. 수정자 주입 방식 (필수 값이 아닐 경우) 동시 사용 가능
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
*/
    /* 일반 메소드 주입
    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    */

    /* setter 주입 방식
    @Autowired 선택, 변경 가능성이 있는 의존 관계에 사용
    @Autowired의 기본 동작은 주입할 대상이 없으면 오류가 발생한다.
    - 주입할 대상이 없어도 동작하게 하려면 @Autowired(required = false)로 지정하면 된다.
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
    */

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
