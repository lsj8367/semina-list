package io.github.lsj8367.infrastructure;

import io.github.lsj8367.domain.Order;
import io.github.lsj8367.domain.OrderRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRegisterImpl implements OrderRegister {

    private final JpaOrderRepository saveRepository;

    public void save(final Order order) {
        saveRepository.save(order);
    }

}
