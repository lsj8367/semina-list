package io.github.lsj8367.application;

import io.github.lsj8367.domain.Member;
import io.github.lsj8367.domain.MemberRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberRegisterService {

    private final MemberRegister memberRegister;

    public void saveMember() {
        for (int i = 0; i < 5; i++) {
            memberRegister.save(new Member("name" + i, "test" + i + "@email.com"));
        }
    }
}
