package io.github.lsj8367.infrastructure;

import io.github.lsj8367.application.MemberQueryService;
import io.github.lsj8367.domain.Member;
import io.github.lsj8367.domain.OrderMemberReader;
import io.github.lsj8367.integrate.OrderMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderMemberReaderImpl implements OrderMemberReader {

    private final MemberQueryService memberQueryService;

    @Override
    public OrderMember findById(final Long id) {
        final Member member = memberQueryService.findById(id);

        return new OrderMember(member.getName(), member.getEmail());
    }
}
