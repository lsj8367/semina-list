package io.github.lsj8367.infrastructure;

import io.github.lsj8367.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends JpaRepository<Member, Long> {

}