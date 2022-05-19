package io.github.lsj8367.interfaces;

import io.github.lsj8367.application.MemberQueryService;
import io.github.lsj8367.domain.Member;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final MemberQueryService memberQueryService;

    @GetMapping("/all")
    public List<Member> findAll() {
        return memberQueryService.findAll();
    }
}
