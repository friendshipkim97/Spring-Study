package spring.Tutorial1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.Tutorial1.discount.DiscountPolicy;
import spring.Tutorial1.discount.FixDiscountPolicy;
import spring.Tutorial1.discount.RateDiscountPolicy;
import spring.Tutorial1.member.MemberRepository;
import spring.Tutorial1.member.MemberService;
import spring.Tutorial1.member.MemberServiceImpl;
import spring.Tutorial1.member.MemoryMemberRepository;
import spring.Tutorial1.order.OrderService;
import spring.Tutorial1.order.OrderServiceImpl;

// AppConfig에서 구현체에 대한 정의를 다 하는 것이다, 이렇게 주입하는 것을 생성자 주입이라고 한다.
@Configuration // @Configuration을 적지 않으면 싱글톤이 깨진다.
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    // Call AppConfig.memberService
    // Call AppConfig.memberRepository
    // Call AppConfig.memberRepository
    // Call AppConfig.orderService
    // Call AppConfig.memberRepository

    // Call AppConfig.memberService
    // Call AppConfig.memberRepository
    // Call AppConfig.orderService

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
