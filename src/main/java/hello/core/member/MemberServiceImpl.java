package hello.core.member;

public class MemberServiceImpl implements MemberService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository(); // 이렇게 구현하면 추상화에도 의존하고 구체화에도 의존한다. DIP위반
    private final MemberRepository memberRepository; // 이렇게 되면 추상화에만 의존한다. DIP를 지키는 것

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
}
