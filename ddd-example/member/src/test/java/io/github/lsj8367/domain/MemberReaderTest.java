package io.github.lsj8367.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberReaderTest {

    MemberReader memberReader = new MemoryMemberReader();

    @Test
    @DisplayName("자바 맵 객체를 이용한 MemberReader test")
    void memoryReaderTest() {
        final List<Member> memberList = memberReader.findAll();
        assertThat(memberList).hasSize(3);
    }

    @Test
    @DisplayName("id 키가 1인 멤버를 조회한다.")
    void findByIdTest() {
        final Member member = memberReader.findById(1L).orElseThrow();

        assertThat(member.getId()).isEqualTo(1L);
        assertThat(member.getName()).isEqualTo("name");
    }

    private static class MemoryMemberReader implements MemberReader {

        private final Map<Long, Member> map;

        public MemoryMemberReader() {
            this.map = Map.of(
                1L, new Member("name", "email"),
                2L, new Member("name2", "email2"),
                3L, new Member("name3", "email3")
            );
        }

        @Override
        public List<Member> findAll() {
            return new ArrayList<>(map.values());
        }

        @Override
        public Optional<Member> findById(final Long id) {
            return Optional.ofNullable(map.get(id));
        }

    }


}