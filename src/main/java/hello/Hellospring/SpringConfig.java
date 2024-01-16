package hello.Hellospring;
import hello.Hellospring.repository.MemberRepository;
import hello.Hellospring.repository.MemoryMemberRepository;
import hello.Hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
