package spring.Tutorial1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.Tutorial1.member.Grade;
import spring.Tutorial1.member.Member;
import spring.Tutorial1.member.MemberService;
import spring.Tutorial1.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

//        MemberService memberService = new MemberServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // 이렇게하면 스프링컨테너에 객체 생성한 것들을 집어넣는다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // getBean메서드의 첫번째 파라미터는 메서드이름, 두번째 파라미터는 반환타입을 의미한다.

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
