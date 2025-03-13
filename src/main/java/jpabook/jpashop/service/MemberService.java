package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 데이터베이스에 멤버 정보를 저장합니다.
     * @param member
     * @return member Id
     * @throws IllegalStateException
     */
    @Transactional(readOnly = false)
    public Long join(Member member) throws IllegalStateException {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 데이터베이스에서 멤버 이름을 조회하여, 중복을 확인합니다.
     * @param member
     * @throws IllegalStateException
     */
    private void validateDuplicateMember(Member member) throws IllegalStateException {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 멤버를 멤버 아이디로 조회합니다.
     * @param id
     * @return member
     */
    public Member findMemberById(Long id) {
        return memberRepository.findById(id);
    }

    /**
     * 데이터베이스의 모든 멤버를 조회합니다.
     * @return list of member`
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
}
