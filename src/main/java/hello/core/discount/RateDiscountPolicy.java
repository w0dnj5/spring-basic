package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // @Primary 시 우선순위를 가짐 @Qualifer 둘 다 존재 시 @Qualifer가 우선 순위를 가짐
// @Qualifier("mainDiscountPolicy") @Qualifer는 @Qualifer는 찾는 용도로 사용하는 게 명확하고 좋음
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
