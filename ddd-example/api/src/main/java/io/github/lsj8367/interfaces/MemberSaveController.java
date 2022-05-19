package io.github.lsj8367.interfaces;

import io.github.lsj8367.application.MemberRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberSaveController {

    private final MemberRegisterService registerService;

    @PostMapping("/member/save")
    public ResponseEntity<Object> saveMember() {
        registerService.saveMember();
        return ResponseEntity.status(201).build();
    }

}
