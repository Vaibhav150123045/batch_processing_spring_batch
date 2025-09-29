package com.example.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public Job sampleJob(JobBuilder jobBuilder, Step sampleStep) {
        return jobBuilder.get("sampleJob")
                .incrementer(new RunIdIncrementer())
                .flow(sampleStep)
                .end()
                .build();
    }

    @Bean
    public Step sampleStep(StepBuilder stepBuilder) {
        return stepBuilder.get("sampleStep")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("Running Sample Step");
                    return null;
                }).build();
    }
}