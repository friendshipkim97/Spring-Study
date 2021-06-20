package spring.Tutorial1.order;

import spring.Tutorial1.discount.DiscountPolicy;
import spring.Tutorial1.discount.FixDiscountPolicy;
import spring.Tutorial1.discount.RateDiscountPolicy;
import spring.Tutorial1.member.Member;
import spring.Tutorial1.member.MemberRepository;
import spring.Tutorial1.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository; // final이 선언되어 있으면 무조건 할당이 되어야함, 생성자를 통해서도 괜찮다.
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 인터페이스에도 의존하고, 구체화에도의존한다.
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 인터페이스에도 의존하고, 구체화에도의존한다.
    private final DiscountPolicy discountPolicy; // 인터페이스에만 의존하게 된다.

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 단일체계원칙 OCP를 잘 지키고 설계한 것이다. 여기서 할인과 관련된 로직이 들어가지 않으므로
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
