package io.github.lsj8367.infrastructure;

import io.github.lsj8367.domain.Member;
import io.github.lsj8367.domain.MemberReader;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberReaderImpl implements MemberReader {

    private final JpaMemberRepository repository;

    @Override
    public List<Member> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Member> findById(final Long id) {
        return repository.findById(id);
    }

}
