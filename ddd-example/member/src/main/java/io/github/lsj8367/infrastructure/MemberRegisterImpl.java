package io.github.lsj8367.infrastructure;

import io.github.lsj8367.domain.Member;
import io.github.lsj8367.domain.MemberRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRegisterImpl implements MemberRegister {

    private final JpaMemberRepository jpaMemberRepository;

    @Override
    public void save(final Member member) {
        jpaMemberRepository.save(member);
    }

}
