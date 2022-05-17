package io.github.lsj8367.repository;

import io.github.lsj8367.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Page<Member> findAllByPoint(final int point, final Pageable pageable);
}