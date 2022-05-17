package io.github.lsj8367.job;

import io.github.lsj8367.entity.Member;
import io.github.lsj8367.repository.MemberRepository;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort.Direction;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class MemberPointJobConfiguration {

    private static final int CHUNK_SIZE = 5;

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final MemberRepository memberRepository;
    private final EntityManagerFactory entityManagerFactory;

    @Bean
    public Job memberJob() {
        return jobBuilderFactory.get("memberJob")
            .start(memberStep())
            .build();
    }

    public Step memberStep() {
        return stepBuilderFactory.get("memberStep")
            .<Member, Member>chunk(CHUNK_SIZE)
            .reader(jpaMemberReader())
//            .reader(pagingItemReader())
            .writer(memberWriter())
            .build();
    }

    // 잘못된 예시 (영속성 문제)
    private RepositoryItemReader<Member> jpaMemberReader() {
        return new RepositoryItemReaderBuilder<Member>()
            .sorts(Map.of("id", Direction.DESC))
            .name("memberRepositoryReader")
            .repository(memberRepository)
            .maxItemCount(CHUNK_SIZE)
            .arguments(0)
            .pageSize(CHUNK_SIZE)
            .methodName("findAllByPoint")
            .build();
    }

    //개선된 Reader
//    private JpaPagingItemReader<Member> pagingItemReader() {
//        JpaPagingItemReader<Member> reader = new JpaPagingItemReader<Member>() {
//            @Override
//            public int getPage() {
//                return 0;
//            }
//        };
//
//        reader.setQueryString("SELECT m FROM Member m WHERE m.point = 0");
//        reader.setPageSize(CHUNK_SIZE);
//        reader.setEntityManagerFactory(entityManagerFactory);
//        reader.setName("payPagingReader");
//
//        return reader;
//    }


    private ItemWriter<Member> memberWriter() {
        return items -> {
            for (Member updateMember : items) {
                updateMember.updatePoint(3000);
            }
        };
    }
}
