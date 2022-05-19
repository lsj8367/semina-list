package io.github.lsj8367.application;

import io.github.lsj8367.domain.Member;
import io.github.lsj8367.domain.MemberReader;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryService {

    private final MemberReader memberReader;

    public List<Member> findAll() {
        return memberReader.findAll();
    }

    public Member findById(final Long id) {
        return memberReader.findById(id).orElseThrow();
    }

}
