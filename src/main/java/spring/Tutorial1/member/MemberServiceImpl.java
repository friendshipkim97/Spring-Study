package spring.Tutorial1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component // Component만 쓰면 빈등록은 되나, 의존관계를 설정할 수 있는 방법이 없으므로 @Autowired를 사용한다.
public class MemberServiceImpl implements MemberService{

    // MemberServiceImpl이 MemberRepository도 의존하고 MemoryMemberRepository도 의존한다.
    // 즉, 추상화에도 의존, 구체화에도 의존하는 것이다. DIP원칙을 지키지 않음, 변경이 있을 때 문제가 된다.
    // private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 이렇게 되면 추상화에만 의존하게 됨, DIP원칙을 지킨 것!, 구체적인건 MemberServiceImpl에서 전혀 모른다.
    private final MemberRepository memberRepository;

    @Autowired // ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
//    @Bean
//    public MemberRepository getMemberRepository() {
//        return memberRepository;
//    }
}
