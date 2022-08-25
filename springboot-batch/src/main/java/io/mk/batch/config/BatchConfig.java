package io.mk.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.mk.batch.listener.JobCompletionListener;
import io.mk.batch.step.Processor;
import io.mk.batch.step.Reader;
import io.mk.batch.step.Writer;

@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job processJob() {
		System.out.println("doJob...");
		return jobBuilderFactory.get("processJob").incrementer(new RunIdIncrementer()).listener(jobListener())
				.flow(processStep()).end().build();
	}

	@Bean
	public JobExecutionListener jobListener() {
		System.out.println("jobListener...");
		return new JobCompletionListener();
	}

	@Bean
	public Step processStep() {
		System.out.println("processStep...");
		return stepBuilderFactory.get("processStep").<String, String>chunk(5).reader(new Reader())
				.processor(new Processor()).writer(new Writer()).build();
	}

}
