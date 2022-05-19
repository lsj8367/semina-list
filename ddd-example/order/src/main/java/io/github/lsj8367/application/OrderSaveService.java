package io.github.lsj8367.application;

import io.github.lsj8367.domain.Order;
import io.github.lsj8367.domain.OrderMemberReader;
import io.github.lsj8367.domain.OrderRegister;
import io.github.lsj8367.integrate.OrderMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderSaveService {

    private final OrderMemberReader memberReader;
    private final OrderRegister orderRegister;

    public void saveOrder(final Long id) {
        final OrderMember orderMember = memberReader.findById(id);
        orderRegister.save(new Order(orderMember));
    }
}
