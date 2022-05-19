package io.github.lsj8367.infrastructure;

import io.github.lsj8367.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<Order, Long> {

}
