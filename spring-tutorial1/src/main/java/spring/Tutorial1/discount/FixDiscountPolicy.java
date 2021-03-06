package spring.Tutorial1.discount;

import org.springframework.stereotype.Component;
import spring.Tutorial1.member.Grade;
import spring.Tutorial1.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 1000원 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ // enum 타입은 == 쓰는게 맞다.
            return discountFixAmount;
        } else{
            return 0;
        }
    }
}
