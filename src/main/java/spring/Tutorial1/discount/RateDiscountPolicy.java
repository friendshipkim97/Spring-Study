package spring.Tutorial1.discount;

import org.springframework.stereotype.Component;
import spring.Tutorial1.member.Grade;
import spring.Tutorial1.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
