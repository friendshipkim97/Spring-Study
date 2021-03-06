package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // 롬복 라이브러리가 제공하는 @RequiredArgsConstructor 기능을 사용하면 final이 붙은 필드를 모아서생성자를 자동으로 만들어준다.
public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 고정할인정책시 , DIP위반이다. 추상(인터페이스)에도 의존하고 구체 클래스도 의존하는것
                                                                             // 인터페이스에 의존해야 하는데, 인터페이스 뿐만 아니라 구체 클래스에도 의존하고 있는 것
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 정률할인정책시

     private final MemberRepository memberRepository; // DIP지킴, final이라 값이 무조건 있어야 함
     private final DiscountPolicy discountPolicy;  // 이렇게 하면 인터페이스에만 의존, DIP는 지켰으나 NullPointerException 오류가 뜬다.

    @Autowired // @Autowired는 생성자가 하나면 생략할 수 있다.
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
