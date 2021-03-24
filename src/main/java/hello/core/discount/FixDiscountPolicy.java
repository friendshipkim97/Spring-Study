package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("fixDiscountPolicy")
@MainDiscountPolicy
public class FixDiscountPolicy implements DiscountPolicy{ // 정액할인정책

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ // enum은 ==사용
            return discountFixAmount;
        } else{
            return 0;
        }
    }


}
