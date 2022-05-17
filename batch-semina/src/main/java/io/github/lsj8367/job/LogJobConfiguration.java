package io.github.lsj8367.job;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // job을 설정해주라는 의미의 문구
@RequiredArgsConstructor
public class LogJobConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogJobConfiguration.class);
    // EnableBatchProcessing 을 해줌으로써 자동으로 얻게 되는 인자
    private final JobBuilderFactory jobBuilderFactory; // Job을 만들어주는 도구
    private final StepBuilderFactory stepBuilderFactory; // Step을 만들어주는 도구

    @Bean
    public Job logJob() {
        return jobBuilderFactory.get("logJob")
            .start(logStep())
            .build();
    }

    @Bean
    public Step logStep() {
        return stepBuilderFactory.get("logStep")
            .tasklet((contribution, chunkContext) -> {
                LOGGER.info("✅ Hello 스프링 배치 세미나");
                return RepeatStatus.FINISHED;
            }).build();
    }

}
