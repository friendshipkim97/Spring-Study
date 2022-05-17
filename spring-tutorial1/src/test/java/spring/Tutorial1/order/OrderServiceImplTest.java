package spring.Tutorial1.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.Tutorial1.discount.FixDiscountPolicy;
import spring.Tutorial1.member.Grade;
import spring.Tutorial1.member.Member;
import spring.Tutorial1.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }


}