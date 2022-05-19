package io.github.lsj8367.interfaces;

import io.github.lsj8367.application.OrderSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderSaveController {

    private final OrderSaveService orderSaveService;

    @PostMapping("/order/save/{memberId}")
    public ResponseEntity<Object> saveOrder(@PathVariable final Long memberId) {
        orderSaveService.saveOrder(memberId);
        return ResponseEntity.status(201).build();
    }

}
