package hello.Hellospring.service;

import hello.Hellospring.domain.Member;
import hello.Hellospring.repository.MemberRepository;
import hello.Hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    회원가입
     */

    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) //옵셔널로 묶여있던걸 바로 찾음
                .ifPresent(m -> { // isnull로 안해도됨 why 옵셔널이라
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    //서비스는 좀 더 친화적으로 나중에 좀 쉽게 리포지토리는 좀 기계적인느낌
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
