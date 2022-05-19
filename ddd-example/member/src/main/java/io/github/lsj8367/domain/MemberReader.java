package io.github.lsj8367.domain;

import java.util.List;
import java.util.Optional;

public interface MemberReader {

    List<Member> findAll();

    Optional<Member> findById(final Long id);
}
