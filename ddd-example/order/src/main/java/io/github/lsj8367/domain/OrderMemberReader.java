package io.github.lsj8367.domain;

import io.github.lsj8367.integrate.OrderMember;

public interface OrderMemberReader {
    OrderMember findById(final Long id);
}
